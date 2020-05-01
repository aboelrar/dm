package www.dm.com.Main_Screen.Scenario_Previous_Analyzis.controller;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import www.dm.com.Main_Screen.Scenario_Previous_Analyzis.model.previous_anal_list;
import www.dm.com.Main_Screen.Scenario_Previous_Analyzis.pattern.previous_anal_adapter;
import www.dm.com.Main_Screen.Scenario_doctor_list.controller.doctor_list;
import www.dm.com.R;
import www.dm.com.utils.utils;
import www.dm.com.utils.utils_adapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class previous_analyzis extends Fragment implements View.OnClickListener {

    View view;
    RecyclerView previous_anal_list;
    Button speak_with_doc;


    public previous_analyzis() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.previous_analyzis, container, false);

        //DEFINE ALL VARS
        previous_anal_list = view.findViewById(R.id.previous_anal_list);
        speak_with_doc = view.findViewById(R.id.speak_with_doc);

        //SET ON CLICK ITEM
        speak_with_doc.setOnClickListener(this);

        get_data(); //GET DATA

        return  view;
    }

    //GET DATA
    void get_data()
    {
        List<www.dm.com.Main_Screen.Scenario_Previous_Analyzis.model.previous_anal_list> arraylist = new ArrayList<>();

        arraylist.add(new previous_anal_list("1","10-10-2020","m/2"));
        arraylist.add(new previous_anal_list("1","10-10-2020","m/2"));
        arraylist.add(new previous_anal_list("1","10-10-2020","m/2"));
        arraylist.add(new previous_anal_list("1","10-10-2020","m/2"));
        arraylist.add(new previous_anal_list("1","10-10-2020","m/2"));

        new utils_adapter().Adapter(previous_anal_list,new previous_anal_adapter(getContext(),arraylist),getContext());
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.speak_with_doc)
        {
            new utils().Replace_Fragment(new doctor_list(),R.id.frag,getContext());
        }
    }
}
