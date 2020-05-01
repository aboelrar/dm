package www.dm.com.Main_Screen.Scenario_messages.controller.Scenario_chat;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import www.dm.com.R;

public class chat extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.finish)
    ImageView finish;
    @BindView(R.id.profile_image)
    CircleImageView profileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);
        ButterKnife.bind(this);

        //SET ON CLICK LISTNER
        finish.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.finish) {
            finish();
        }
    }
}
