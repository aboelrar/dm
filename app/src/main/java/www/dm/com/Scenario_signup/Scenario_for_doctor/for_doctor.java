package www.dm.com.Scenario_signup.Scenario_for_doctor;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import www.dm.com.Main_Screen.MainActivity;
import www.dm.com.R;
import www.dm.com.Scenario_login.loading;
import www.dm.com.Scenario_login.login;

/**
 * A simple {@link Fragment} subclass.
 */
public class for_doctor extends Fragment implements View.OnClickListener {

    View view;
    Button sign_up;
    TextView sign_in;

    public for_doctor() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.for_doctor, container, false);

        //DEFINE ALL VARS
        sign_in = view.findViewById(R.id.signin);
        sign_up = view.findViewById(R.id.signup);

        //SET ON CLICK ITEM LISTNERS
        sign_in.setOnClickListener(this);
        sign_up.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.signin)
        {
            startActivity(new Intent(getContext(), login.class));
        }
        else if(view.getId() == R.id.signup)
        {
            loading loading = new loading();
            loading.dialog(getContext(), R.layout.successful_login, .80);        }

    }
}
