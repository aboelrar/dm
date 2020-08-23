package www.dm.com.Main_Screen.Scenario_analyze;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.addisonelliott.segmentedbutton.SegmentedButtonGroup;
import com.android.volley.VolleyError;

import org.json.JSONException;

import java.util.ArrayList;

import es.dmoral.toasty.Toasty;
import www.dm.com.Main_Screen.Scenario_analyzes_dates.controller.analizing_dates;
import www.dm.com.Main_Screen.Scenario_result.result;
import www.dm.com.NetworkLayer.Apicalls;
import www.dm.com.NetworkLayer.NetworkInterface;
import www.dm.com.NetworkLayer.ResponseModel;
import www.dm.com.R;
import www.dm.com.local_data.saved_data;
import www.dm.com.utils.utils;

/**
 * A simple {@link Fragment} subclass.
 */
public class analyze extends Fragment implements View.OnClickListener, NetworkInterface {

    View view;
    TextView result;
    SegmentedButtonGroup sugar_type;
    String sugar_type_txt = "first";
    EditText sugar_per;
    SegmentedButtonGroup pregnancy;
    String pregnancy_txt = "1";
    SegmentedButtonGroup pharmaceutical;
    String pharmaceutical_txt = "insulin";
    SegmentedButtonGroup sugar_since;
    String sugar_since_txt = "1-5";
    SegmentedButtonGroup complications;
    String complications_txt = "eye";
    Spinner insulin_type;
    LinearLayout doseli_1, doseli_2, doseli_3, doseli_4, doseli_5;
    EditText dose1, dose2, dose3, dose4, dose5;
    String insulin_type_st = "no_word";

    public analyze() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.analyze, container, false);

        //RESULT BUTTON
        result = view.findViewById(R.id.analzing);
        result.setOnClickListener(this);

        //DEFINE ALL VARS
        dose1 = view.findViewById(R.id.dose1);
        dose2 = view.findViewById(R.id.dose2);
        dose3 = view.findViewById(R.id.dose3);
        dose4 = view.findViewById(R.id.dose4);
        dose5 = view.findViewById(R.id.dose5);

        //GET SEGMENTS DATA
        setSugar_type();
        set_pregnancy();
        set_pharmaceutical();
        set_sugar_since();
        set_complications();
        setSugar_per();
        ansulin_type();


        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.analzing) {

            if (setSugar_per().length() == 0) {
                Toasty.warning(getContext(), getResources().getString(R.string.insert_sugar_per), Toasty.LENGTH_LONG).show();
            } else if (insulin_type_st.equals("no_word")) {
                Toasty.warning(getContext(), getResources().getString(R.string.pls_choose_insulin_type), Toasty.LENGTH_LONG).show();
            } else if ((insulin_type_st.equals(getString(R.string.premixed)) ||
                    (insulin_type_st.equals(R.string.long_acting) || (insulin_type_st.equals(R.string.nph))
                            || (insulin_type_st.equals(R.string.basal))))) {
                if (dose1.getText().toString().equals("")) {
                    Toasty.warning(getContext(), getResources().getString(R.string.insert_dose_one), Toasty.LENGTH_LONG).show();
                } else if (dose2.getText().toString().equals("")) {
                    Toasty.warning(getContext(), getResources().getString(R.string.insert_dose_two), Toasty.LENGTH_LONG).show();
                } else {
                    try {
                        //CALL PROGRESS DIALOG
                        new utils().set_dialog(getContext());

                        new Apicalls(getContext(), this).SET_SUAGR_DATA(new saved_data().get_id(getContext()), sugar_type_txt, setSugar_per(), pregnancy_txt, pharmaceutical_txt, sugar_since_txt, complications_txt, insulin_type_st, dose1.getText().toString(), dose2.getText().toString(),
                                dose3.getText().toString(), dose4.getText().toString(), dose5.getText().toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            } else if ((insulin_type_st.equals(getString(R.string.rapid)))) {
                if (dose1.getText().toString().equals("")) {
                    Toasty.warning(getContext(), getResources().getString(R.string.insert_dose_one), Toasty.LENGTH_LONG).show();
                } else if (dose2.getText().toString().equals("")) {
                    Toasty.warning(getContext(), getResources().getString(R.string.insert_dose_two), Toasty.LENGTH_LONG).show();
                } else if (dose3.getText().toString().equals("")) {
                    Toasty.warning(getContext(), getResources().getString(R.string.insert_dose_there), Toasty.LENGTH_LONG).show();
                } else {
                    try {
                        //CALL PROGRESS DIALOG
                        new utils().set_dialog(getContext());

                        new Apicalls(getContext(), this).SET_SUAGR_DATA(new saved_data().get_id(getContext()), sugar_type_txt, setSugar_per(), pregnancy_txt, pharmaceutical_txt, sugar_since_txt, complications_txt, insulin_type_st, dose1.getText().toString(), dose2.getText().toString(),
                                dose3.getText().toString(), dose4.getText().toString(), dose5.getText().toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            } else if ((insulin_type_st.equals(getString(R.string.long_)) ||
                    (insulin_type_st.equals(getString(R.string.short_acting))))) {
                if (dose1.getText().toString().equals("")) {
                    Toasty.warning(getContext(), getResources().getString(R.string.insert_dose_one), Toasty.LENGTH_LONG).show();
                } else if (dose2.getText().toString().equals("")) {
                    Toasty.warning(getContext(), getResources().getString(R.string.insert_dose_two), Toasty.LENGTH_LONG).show();
                } else if (dose3.getText().toString().equals("")) {
                    Toasty.warning(getContext(), getResources().getString(R.string.insert_dose_there), Toasty.LENGTH_LONG).show();
                } else if (dose4.getText().toString().equals("")) {
                    Toasty.warning(getContext(), getResources().getString(R.string.insert_dose_four), Toasty.LENGTH_LONG).show();
                } else if (dose5.getText().toString().equals("")) {
                    Toasty.warning(getContext(), getResources().getString(R.string.insert_dose_five), Toasty.LENGTH_LONG).show();
                } else {
                    try {
                        //CALL PROGRESS DIALOG
                        new utils().set_dialog(getContext());

                        new Apicalls(getContext(), this).SET_SUAGR_DATA(new saved_data().get_id(getContext()), sugar_type_txt, setSugar_per(), pregnancy_txt, pharmaceutical_txt, sugar_since_txt, complications_txt, insulin_type_st, dose1.getText().toString(), dose2.getText().toString(),
                                dose3.getText().toString(), dose4.getText().toString(), dose5.getText().toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public void OnStart() {

    }

    @Override
    public void OnResponse(ResponseModel model) {

        //DISMISS DIALOG
        new utils().dismiss_dialog(getContext());

        Toasty.success(getContext(), "Data Set!", Toasty.LENGTH_LONG).show();

        //GO TO NEXT PAGE
        new utils().Replace_Fragment(new analizing_dates(), R.id.frag, getContext());

    }

    @Override
    public void OnError(VolleyError error) {

        //DISMISS DIALOG
        new utils().dismiss_dialog(getContext());

        Toasty.warning(getContext(), getResources().getString(R.string.user_exist), Toasty.LENGTH_LONG).show();
    }

    //SEGMENT SUGAR TYPE
    String setSugar_type() {
        sugar_type = view.findViewById(R.id.sugar_type);
        sugar_type.setOnPositionChangedListener(new SegmentedButtonGroup.OnPositionChangedListener() {
            @Override
            public void onPositionChanged(int position) {

                if (position == 0) {
                    sugar_type_txt = "first";
                } else if (position == 1) {
                    sugar_type_txt = "second";
                } else if (position == 2) {
                    sugar_type_txt = "pregnancy";
                } else if (position == 3) {
                    sugar_type_txt = "other";
                }
            }

        });

        return sugar_type_txt;
    }

    //TEXT SUGAR PER
    String setSugar_per() {
        ImageView check_image = view.findViewById(R.id.check_image);
        sugar_per = view.findViewById(R.id.sugar_per);
        sugar_per.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                check_image.setVisibility(View.GONE);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 0) {
                    check_image.setVisibility(View.GONE);
                } else {
                    check_image.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        return sugar_per.getText().toString();
    }

    //SEGMENT PREGNANCY
    String set_pregnancy() {
        pregnancy = view.findViewById(R.id.pregnancy);
        pregnancy.setOnPositionChangedListener(new SegmentedButtonGroup.OnPositionChangedListener() {
            @Override
            public void onPositionChanged(int position) {
                if (position == 0) {
                    pregnancy_txt = "1";
                } else if (position == 1) {
                    pregnancy_txt = "0";
                }
            }
        });
        return pregnancy_txt;
    }

    //SEGMENT PHARMACEUTICAL
    String set_pharmaceutical() {
        pharmaceutical = view.findViewById(R.id.pharmaceutical);
        pharmaceutical.setOnPositionChangedListener(new SegmentedButtonGroup.OnPositionChangedListener() {
            @Override
            public void onPositionChanged(int position) {
                if (position == 0) {
                    pharmaceutical_txt = "insulin";
                } else if (position == 1) {
                    pharmaceutical_txt = "inject";
                } else if (position == 2) {
                    pharmaceutical_txt = "pills";
                }
            }
        });
        return pharmaceutical_txt;
    }

    //SEGMENT SUGAR SINCE
    String set_sugar_since() {
        sugar_since = view.findViewById(R.id.sugar_since);
        sugar_since.setOnPositionChangedListener(new SegmentedButtonGroup.OnPositionChangedListener() {
            @Override
            public void onPositionChanged(int position) {
                if (position == 0) {
                    sugar_since_txt = "1-5";
                } else if (position == 1) {
                    sugar_since_txt = "5-10";
                } else if (position == 2) {
                    sugar_since_txt = "10+";
                }
            }
        });
        return sugar_since_txt;
    }

    //SEGMENT COMPLICATIONS
    String set_complications() {
        complications = view.findViewById(R.id.complications);
        complications.setOnPositionChangedListener(new SegmentedButtonGroup.OnPositionChangedListener() {
            @Override
            public void onPositionChanged(int position) {
                if (position == 0) {
                    complications_txt = "eye";
                } else if (position == 1) {
                    complications_txt = "heart";
                } else if (position == 2) {
                    complications_txt = "arterioles";
                } else if (position == 3) {
                    complications_txt = "kidney";
                } else if (position == 4) {
                    complications_txt = "other";
                }
            }
        });
        return complications_txt;
    }

    //SET ANSULIN TYPE
    void ansulin_type() {

        LinearLayout insulin_type_spinner = view.findViewById(R.id.insulin_type_spinner);
        insulin_type = view.findViewById(R.id.insulin_type);
        doseli_1 = view.findViewById(R.id.dose1_li);
        doseli_2 = view.findViewById(R.id.dose2_li);
        doseli_3 = view.findViewById(R.id.dose3_li);
        doseli_4 = view.findViewById(R.id.dose4_li);
        doseli_5 = view.findViewById(R.id.dose5_li);


        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(getString(R.string.choose_insulin));
        arrayList.add(getString(R.string.premixed));
        arrayList.add(getString(R.string.rapid));
        arrayList.add(getString(R.string.short_acting));
        arrayList.add(getString(R.string.long_acting));
        arrayList.add(getString(R.string.nph));
        arrayList.add(getString(R.string.basal));
        arrayList.add(getString(R.string.long_));
        arrayList.add(getString(R.string.short_acting));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, arrayList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        insulin_type.setAdapter(adapter);

        insulin_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                insulin_type_st = arrayList.get(i);

                if (i == 0) {
                    insulin_type_spinner.setVisibility(View.GONE);
                } else if ((i == 1) || (i == 4) || (i == 5) || (i == 6)) {
                    insulin_type_spinner.setVisibility(View.VISIBLE);
                    doseli_3.setVisibility(View.GONE);
                    doseli_4.setVisibility(View.GONE);
                    doseli_5.setVisibility(View.GONE);
                } else if (i == 2) {
                    insulin_type_spinner.setVisibility(View.VISIBLE);
                    doseli_3.setVisibility(View.VISIBLE);
                    doseli_4.setVisibility(View.GONE);
                    doseli_5.setVisibility(View.GONE);
                } else if ((i == 7) || (i == 8)) {
                    insulin_type_spinner.setVisibility(View.VISIBLE);
                    doseli_3.setVisibility(View.VISIBLE);
                    doseli_4.setVisibility(View.VISIBLE);
                    doseli_5.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }


}
