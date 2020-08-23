package www.dm.com.Scenario_signup.Scenario_for_user;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.google.gson.Gson;

import es.dmoral.toasty.Toasty;
import www.dm.com.NetworkLayer.Apicalls;
import www.dm.com.NetworkLayer.NetworkInterface;
import www.dm.com.NetworkLayer.ResponseModel;
import www.dm.com.R;
import www.dm.com.Scenario_login.controller.loading;
import www.dm.com.Scenario_login.controller.login;
import www.dm.com.Scenario_signup.model.signupRootClass;
import www.dm.com.Scenario_signup.model.signupUserDatum;
import www.dm.com.local_data.send_data;
import www.dm.com.utils.utils;

import static www.dm.com.utils.utils.yoyo;

/**
 * A simple {@link Fragment} subclass.
 */
public class for_user extends Fragment implements View.OnClickListener, NetworkInterface {

    View view;
    Button sign_up;
    TextView sign_in;
    EditText username;
    EditText password;
    EditText co_pass;
    EditText email;
    signupRootClass signupRootClass;
    www.dm.com.Scenario_signup.model.signupUserDatum signupUserDatum;

    public for_user() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.for_user, container, false);

        //DEFINE ALL VARS
        sign_in = view.findViewById(R.id.signin);
        sign_up = view.findViewById(R.id.signup);
        username = view.findViewById(R.id.username);
        email = view.findViewById(R.id.useremail);
        password = view.findViewById(R.id.password);
        co_pass = view.findViewById(R.id.co_password);

        //SET ON CLICK ITEM LISTNERS
        sign_in.setOnClickListener(this);
        sign_up.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.signin) {
            startActivity(new Intent(getContext(), login.class));
        }
        else if (view.getId() == R.id.signup) {
            signup_validation();
        }
    }


    @Override
    public void OnStart() {

    }

    @Override
    public void OnResponse(ResponseModel model) {
        //DISMISS DIALOG
        new utils().dismiss_dialog(getContext());

        //CONVERT FROM OBJECT
        Gson gson = new Gson();
        signupRootClass = gson.fromJson(""+model.getResponse(), signupRootClass.class);
        signupUserDatum = signupRootClass.getUserData();

        //SAVE IN LOCAL DATA
        send_data.send_name(getContext(), signupUserDatum.getUserName());
        send_data.send_email(getContext(), signupUserDatum.getUserEmail());
        send_data.send_id(getContext(), signupUserDatum.getUserId());
        send_data.login_status(getContext(), true);


        loading loading = new loading();
        loading.dialog(getContext(), R.layout.successful_login, .80);
    }

    @Override
    public void OnError(VolleyError error) {
        if(error.networkResponse.statusCode == 503)
        {
            //DISMISS DIALOG
            new utils().dismiss_dialog(getContext());

            Toasty.error(getContext(),getResources().getString(R.string.user_exsit),Toasty.LENGTH_LONG).show();
        }
    }

    //SIGN UP VAILDATION
    void signup_validation() {

        if (username.getText().toString().length() < 5)  //VALIDATION ON USERNAME
        {
            String username_val = getResources().getString(R.string.user_val);
            username.setError(username_val);
            yoyo(R.id.username, username);
        } else if (email.getText().toString().length() < 6)  //VALIDATION ON EMAIL
        {
            String email_val = getResources().getString(R.string.email_val);
            email.setError(email_val);
            yoyo(R.id.useremail, email);
        } else if (password.getText().toString().length() < 6)  //VALIDATION ON PASSWORD
        {
            String pass_val = getResources().getString(R.string.password_val);
            password.setError(pass_val);
            yoyo(R.id.password, password);
        } else if (!co_pass.getText().toString().equals(password.getText().toString()))  //VALIDATION ON CONFIRM PASSWORD
        {
            String co_pass_val = getResources().getString(R.string.copassword_val);
            co_pass.setError(co_pass_val);
            yoyo(R.id.co_password, co_pass);
        } else {

            //CALL PROGRESS DIALOG
            new utils().set_dialog(getContext());

            //CALL API
            new Apicalls(getContext(), this).insertDoctor(username.getText().toString(), email.getText().toString(),
                    password.getText().toString(), "", "patient");
        }
    }
}
