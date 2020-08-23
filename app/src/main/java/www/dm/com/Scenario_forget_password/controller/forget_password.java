package www.dm.com.Scenario_forget_password.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import www.dm.com.R;
import www.dm.com.Scenario_reset_password.controller.reset_password;

public class forget_password extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.send_mail)
    Button sendMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_password);
        ButterKnife.bind(this);

        //SET ON CLICK LISTNERS
        sendMail.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.send_mail)
        {
            startActivity(new Intent(forget_password.this, reset_password.class));
        }
    }
}
