package www.dm.com.Lets_go;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import www.dm.com.Main_Screen.MainActivity;
import www.dm.com.R;
import www.dm.com.Scenario_login.controller.login;
import www.dm.com.local_data.saved_data;

public class lets_go extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.lets_go)
    Button letsGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lets_go);
        ButterKnife.bind(this);

        //SET ON CLICK LISTNER ITEM
        letsGo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.lets_go) {
            if (new saved_data().get_login_status(lets_go.this) == true)
            {
                startActivity(new Intent(lets_go.this, MainActivity.class));
            }
            else {
                startActivity(new Intent(lets_go.this, login.class));
            }
        }
    }
}
