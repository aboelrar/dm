package www.dm.com.Main_Screen.Scenario_doctor_list.pattern;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import www.dm.com.Main_Screen.Scenario_doctor_list.controller.Scenario_doc_details.doc_details;
import www.dm.com.Main_Screen.Scenario_doctor_list.model.doc_list;
import www.dm.com.R;

public class doc_list_adapter extends RecyclerView.Adapter<doc_list_adapter.view_Holder> implements View.OnClickListener {

    Context context;
    List<doc_list>mylist;

    public doc_list_adapter(Context context, List<doc_list> mylist) {
        this.context = context;
        this.mylist = mylist;
    }

    @NonNull
    @Override
    public view_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.doctor_item,parent,false);
        view_Holder view_holder = new view_Holder(view);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull view_Holder holder, int position) {
        holder.name.setText(mylist.get(position).getName());
        holder.desc.setText(mylist.get(position).getDesc());

        //SET ON CLICK ITEM
        holder.doc_item.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.doc_item)
        {
            doc_details doc_details = new doc_details();
            doc_details.show(((AppCompatActivity)context).getSupportFragmentManager(),"doc_list");
        }
    }

    public class view_Holder extends RecyclerView.ViewHolder {
        TextView name,desc;
        LinearLayout doc_item;
        public view_Holder(@NonNull View itemView) {
            super(itemView);
            name=  itemView.findViewById(R.id.name);
            desc = itemView.findViewById(R.id.desc);
            doc_item= itemView.findViewById(R.id.doc_item);
         }
    }
}
