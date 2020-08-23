package www.dm.com.Scenario_reset_password.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import www.dm.com.R;
import www.dm.com.Scenario_login.controller.login;

public class reset_password extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.new_pass)
    EditText newPass;
    @BindView(R.id.renew_pass)
    EditText renewPass;
    @BindView(R.id.verify)
    Button verify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reset_password);
        ButterKnife.bind(this);

        //SET ON CLICK LISTNERS
        verify.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
       if(view.getId() == R.id.verify)
       {
           startActivity(new Intent(reset_password.this, login.class));
       }
    }
}
