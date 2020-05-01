package www.dm.com.Main_Screen.Scenario_analyze;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import www.dm.com.Main_Screen.Scenario_result.result;
import www.dm.com.R;
import www.dm.com.utils.utils;

/**
 * A simple {@link Fragment} subclass.
 */
public class analyze extends Fragment implements View.OnClickListener {

    View view;
    TextView result;

    public analyze() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.analyze, container, false);

        //DEFINE VARS
        result = view.findViewById(R.id.analzing);

        //SET ON CLICK LISTNERS
        result.setOnClickListener(this);



        return view;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() ==R.id.analzing)
        {
            new utils().Replace_Fragment(new result(),R.id.frag,getContext());
        }
    }
}
