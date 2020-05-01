package www.dm.com.Main_Screen.Scenario_doctor_list.controller;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import www.dm.com.Main_Screen.Scenario_doctor_list.model.doc_list;
import www.dm.com.Main_Screen.Scenario_doctor_list.pattern.doc_list_adapter;
import www.dm.com.R;
import www.dm.com.utils.utils_adapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class doctor_list extends Fragment {

    RecyclerView doc_list;
    View view;


    public doctor_list() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.doctor_list, container, false);

        //DEFINE ALL VARS
        doc_list = view.findViewById(R.id.doctor_list);

        get_data(); //GET DATA

        return  view;
    }

    //GET DATA
    void get_data()
    {
        List<www.dm.com.Main_Screen.Scenario_doctor_list.model.doc_list> arraylist = new ArrayList<>();
        arraylist.add(new doc_list("11","1","Dr magda sultan","doctor speciality"));
        arraylist.add(new doc_list("11","1","Dr magda sultan","doctor speciality"));
        arraylist.add(new doc_list("11","1","Dr magda sultan","doctor speciality"));
        arraylist.add(new doc_list("11","1","Dr magda sultan","doctor speciality"));
        arraylist.add(new doc_list("11","1","Dr magda sultan","doctor speciality"));

        new utils_adapter().Adapter(doc_list,new doc_list_adapter(getContext(),arraylist),getContext());
    }

}
