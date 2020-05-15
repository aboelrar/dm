package www.dm.com.Scenario_signup;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.addisonelliott.segmentedbutton.SegmentedButtonGroup;

import java.util.EventListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import www.dm.com.R;
import www.dm.com.Scenario_signup.Scenario_for_doctor.for_doctor;
import www.dm.com.Scenario_signup.Scenario_for_user.for_user;
import www.dm.com.utils.utils;

public class signup extends AppCompatActivity {

    @BindView(R.id.buttonGroup_lordOfTheRings)
    SegmentedButtonGroup buttonGroupLordOfTheRings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        ButterKnife.bind(this);


        //ADD FRAGMENT TO PAGE AT FIRST
        new utils().Replace_Fragment(new for_user(), R.id.frag, this);

        check_seghments(); //CHECK IF USER OR DOCTOR
    }

   void check_seghments()
   {
       buttonGroupLordOfTheRings.setOnPositionChangedListener(new SegmentedButtonGroup.OnPositionChangedListener() {
           @Override
           public void onPositionChanged(int position) {
               if(position==0)
               {
                   new utils().Replace_Fragment(new for_user(), R.id.frag, signup.this); //FRAGMENT FRO USER

               }
               else if(position == 1)
               {
                   new utils().Replace_Fragment(new for_doctor(), R.id.frag, signup.this); //FRAGMENT FRO Doctor
               }
           }
       });
   }
}
