package www.dm.com.Main_Screen.Scenario_analyzes_dates.controller;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.addisonelliott.segmentedbutton.SegmentedButton;
import com.addisonelliott.segmentedbutton.SegmentedButtonGroup;
import com.android.volley.VolleyError;

import java.util.Date;

import es.dmoral.toasty.Toasty;
import www.dm.com.Main_Screen.Scenario_result.result;
import www.dm.com.NetworkLayer.Apicalls;
import www.dm.com.NetworkLayer.NetworkInterface;
import www.dm.com.NetworkLayer.ResponseModel;
import www.dm.com.R;
import www.dm.com.Scenario_signup.Scenario_for_doctor.for_doctor;
import www.dm.com.Scenario_signup.Scenario_for_user.for_user;
import www.dm.com.Scenario_signup.signup;
import www.dm.com.local_data.saved_data;
import www.dm.com.local_data.send_data;
import www.dm.com.utils.utils;

/**
 * A simple {@link Fragment} subclass.
 */
public class analizing_dates extends Fragment implements View.OnClickListener, NetworkInterface {

    SegmentedButtonGroup days_segments;
    View view;
    Button days_analyzes_btn;
    EditText saim, after_b, before_l, after_l, before_d, after_d, mid_night;
    SegmentedButton day;

    public analizing_dates() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.analizing_dates, container, false);

        //DEFINE SEGMENT
        days_segments = view.findViewById(R.id.days_segmants);
        days_analyzes_btn = view.findViewById(R.id.days_analyzes);
        saim = view.findViewById(R.id.saim);
        after_b = view.findViewById(R.id.after_b);
        before_l = view.findViewById(R.id.before_l);
        after_l = view.findViewById(R.id.after_l);
        before_d = view.findViewById(R.id.before_d);
        after_d = view.findViewById(R.id.after_d);
        mid_night = view.findViewById(R.id.mid_night);
        day = view.findViewById(R.id.day);

        //SET ON CLICK
        days_analyzes_btn.setOnClickListener(this);

        //CHECK SEGMENTS
        check_seghments();

        return view;
    }

    void check_seghments() {
        days_segments.setOnPositionChangedListener(new SegmentedButtonGroup.OnPositionChangedListener() {
            @Override
            public void onPositionChanged(int position) {
                if (position == 3) {
                    //ANALIZE
                    days_analyzes_btn.setText(R.string.analyzing);
                    days_analyzes_btn.setOnClickListener(analizing_dates.this);
                } else {
                    //ANALIZE
                    days_analyzes_btn.setText(R.string.done);
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.days_analyzes) {
            set_dialy_date();
        }

    }

    void set_dialy_date() {


        String currentDateTimeStrings = java.text.DateFormat.getDateTimeInstance().format(new Date());

        if ((saim.getText().toString().equals("")) || (after_b.getText().toString().equals("")) || (before_l.getText().toString().equals(""))
                || (after_l.getText().toString().equals("")) || (before_d.getText().toString().equals("")) || (after_d.getText().toString().equals(""))
                || (mid_night.getText().toString().equals(""))) {
            Toasty.warning(getContext(), getString(R.string.pls_insert_all_data), Toasty.LENGTH_SHORT).show();
        } else {

            if (new saved_data().get_day(getContext()) != 5) {

                new utils().set_dialog(getContext());

                new Apicalls(getContext(), analizing_dates.this).set_dialy_data(new saved_data().get_id(getContext()), "" + new saved_data().get_day(getContext()),
                        after_b.getText().toString(), before_l.getText().toString(), after_l.getText().toString(), before_d.getText().toString(),
                        after_d.getText().toString(), mid_night.getText().toString());

                send_data.add_day(getContext(), new saved_data().get_day(getContext()) + 1);

                day.setText("" + getString(R.string.day) + " " + new saved_data().get_day(getContext()));

            } else {
                send_data.add_day(getContext(), 1);
            }


        }

    }

    @Override
    public void OnStart() {

    }

    @Override
    public void OnResponse(ResponseModel model) {
        Toast.makeText(getContext(), "" + model.getResponse(), Toast.LENGTH_LONG).show();

        new utils().dismiss_dialog(getContext());

        String currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new Date());
        Log.e("time_is", currentDateTimeString);

        //SET DATA IN DATE
        send_data.add_data(getContext(), currentDateTimeString);
    }

    @Override
    public void OnError(VolleyError error) {
        Toast.makeText(getContext(), "" + error.networkResponse.statusCode, Toast.LENGTH_LONG).show();
    }
}
