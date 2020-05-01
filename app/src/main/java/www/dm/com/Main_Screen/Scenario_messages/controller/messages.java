package www.dm.com.Main_Screen.Scenario_messages.controller;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import www.dm.com.Main_Screen.Scenario_messages.model.msg_list;
import www.dm.com.Main_Screen.Scenario_messages.pattern.messages_adapter;
import www.dm.com.R;
import www.dm.com.utils.utils_adapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class messages extends Fragment {

    View view;
    RecyclerView msg_list;

    public messages() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.messages, container, false);

        //DEFINE ALL VARS
        msg_list = view.findViewById(R.id.msg_list);

        get_data();

        return view;
    }

    //GET DATA
    void get_data()
    {
        List<www.dm.com.Main_Screen.Scenario_messages.model.msg_list> arraylist = new ArrayList<>();

        arraylist.add(new msg_list("1","ahmed taha","yes you can use it after breakfast","10:18 AM"));
        arraylist.add(new msg_list("1","ahmed taha","yes you can use it after breakfast","10:18 AM"));
        arraylist.add(new msg_list("1","ahmed taha","yes you can use it after breakfast","10:18 AM"));
        arraylist.add(new msg_list("1","ahmed taha","yes you can use it after breakfast","10:18 AM"));

        new utils_adapter().Adapter(msg_list,new messages_adapter(getContext(),arraylist),getContext());
    }

}
