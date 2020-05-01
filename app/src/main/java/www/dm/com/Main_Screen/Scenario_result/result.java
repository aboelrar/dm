package www.dm.com.Main_Screen.Scenario_result;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import www.dm.com.Main_Screen.Scenario_doctor_list.controller.doctor_list;
import www.dm.com.R;
import www.dm.com.utils.utils;

/**
 * A simple {@link Fragment} subclass.
 */
public class result extends Fragment implements View.OnClickListener {

    View view;
    TextView speak_with_doc;

    public result() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.result, container, false);

        //DEFINE ALL VARS
        speak_with_doc = view.findViewById(R.id.speak_with_doc);

        //SET ON CLICK LISTNERS
        speak_with_doc.setOnClickListener(this);

        return  view;
    }

    @Override
    public void onClick(View view) {
         if(view.getId() ==R.id.speak_with_doc)
         {
             new utils().Replace_Fragment(new doctor_list(),R.id.frag,getContext());
         }
    }
}
