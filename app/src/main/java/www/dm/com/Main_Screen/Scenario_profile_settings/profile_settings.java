package www.dm.com.Main_Screen.Scenario_profile_settings;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import www.dm.com.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class profile_settings extends Fragment {


    public profile_settings() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.profile_settings, container, false);
    }

}
