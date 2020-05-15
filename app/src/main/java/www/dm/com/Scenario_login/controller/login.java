package www.dm.com.Scenario_login.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.addisonelliott.segmentedbutton.SegmentedButtonGroup;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import www.dm.com.NetworkLayer.Apicalls;
import www.dm.com.NetworkLayer.NetworkInterface;
import www.dm.com.NetworkLayer.ResponseModel;
import www.dm.com.R;
import www.dm.com.Scenario_login.model.login_model;
import www.dm.com.local_data.send_data;
import www.dm.com.utils.utils;

import static www.dm.com.utils.utils.yoyo;

public class login extends AppCompatActivity implements View.OnClickListener, NetworkInterface {

    @BindView(R.id.buttonGroup_lordOfTheRings)
    SegmentedButtonGroup buttonGroupLordOfTheRings;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.signup)
    TextView signup;
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;

    login_model login_model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ButterKnife.bind(this);

        //SET ON CLICK LISTNER
        signup.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.signup) {
            startActivity(new Intent(login.this, www.dm.com.Scenario_signup.signup.class));
        } else if (view.getId() == R.id.login) {
            login_validation();
        }
    }

    //LOGIN VAILDATION
    void login_validation() {

        if (username.getText().toString().length() < 5)  //VALIDATION ON USERNAME
        {
            String username_val = getResources().getString(R.string.user_val);
            username.setError(username_val);
            yoyo(R.id.username, username);
        } else if (password.getText().toString().length() < 6)  //VALIDATION ON PASSWORD
        {
            String pass_val = getResources().getString(R.string.password_val);
            password.setError(pass_val);
            yoyo(R.id.password, password);
        } else {

            //CALL PROGRESS DIALOG
            new utils().set_dialog(this);

            //CALL API
            new Apicalls(this, this).loginUser(username.getText().toString(), password.getText().toString());
        }
    }

    @Override
    public void OnStart() {

    }

    @Override
    public void OnResponse(ResponseModel model) {

        //DISMISS DIALOG
        new utils().dismiss_dialog(this);

        //GET MODEL RESPONSE
        Gson gson = new Gson();
        login_model = gson.fromJson("" + model.getResponse(), www.dm.com.Scenario_login.model.login_model.class);

        //SAVE IN LOCAL DATA
        send_data.send_name(this,login_model.getName());
        send_data.send_email(this,login_model.getUserEmail());
        send_data.send_id(this,login_model.getId());

        //OPEN DIALOG
        loading loading = new loading();
        loading.dialog(login.this, R.layout.successful_login, .80);

    }

    @Override
    public void OnError(VolleyError error) {
        if (error.networkResponse.statusCode == 503) {
            //DISMISS DIALOG
            new utils().dismiss_dialog(this);

            Toasty.error(this, getResources().getString(R.string.user_not_found), Toasty.LENGTH_LONG).show();
        }
    }
}
