package www.dm.com.Scenario_login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.addisonelliott.segmentedbutton.SegmentedButtonGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import www.dm.com.Main_Screen.MainActivity;
import www.dm.com.R;
import www.dm.com.Scenario_signup.signup;

public class login extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.buttonGroup_lordOfTheRings)
    SegmentedButtonGroup buttonGroupLordOfTheRings;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.signup)
    TextView signup;

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
        if(view.getId() ==R.id.signup)
        {
            startActivity(new Intent(login.this, www.dm.com.Scenario_signup.signup.class));
        }
        else if(view.getId() == R.id.login)
        {
            loading loading = new loading();
            loading.dialog(login.this, R.layout.successful_login, .80);
        }
    }
}
