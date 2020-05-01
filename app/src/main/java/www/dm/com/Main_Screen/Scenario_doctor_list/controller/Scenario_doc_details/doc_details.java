package www.dm.com.Main_Screen.Scenario_doctor_list.controller.Scenario_doc_details;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import www.dm.com.Main_Screen.Scenario_messages.controller.Scenario_chat.chat;
import www.dm.com.R;

public class doc_details extends BottomSheetDialogFragment implements View.OnClickListener {
    ImageView phone,chatting;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.doc_details_bottomsheet,container,false);

       //DEFINE ALL VARS
        phone = view.findViewById(R.id.phone);
        chatting = view.findViewById(R.id.chat);

        //SET ON CLICK LISTNET
        chatting.setOnClickListener(this);
        phone.setOnClickListener(this);

       return view;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.chat)
        {
            startActivity(new Intent(getContext(), www.dm.com.Main_Screen.Scenario_messages.controller.Scenario_chat.chat.class));
        }
        else if(view.getId() == R.id.phone)
        {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:0123456789"));
            startActivity(intent);
        }
    }
}
