package www.dm.com.Main_Screen.Scenario_Previous_Analyzis.pattern;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import www.dm.com.Main_Screen.Scenario_Previous_Analyzis.controller.Scenario_analyze_details_bottomsheet.analyze_details;
import www.dm.com.Main_Screen.Scenario_Previous_Analyzis.model.previous_anal_list;
import www.dm.com.Main_Screen.Scenario_doctor_list.controller.Scenario_doc_details.doc_details;
import www.dm.com.R;

public class previous_anal_adapter extends RecyclerView.Adapter<previous_anal_adapter.view_holder> implements View.OnClickListener {

    Context context;
    List<previous_anal_list>mylist;

    public previous_anal_adapter(Context context, List<previous_anal_list> mylist) {
        this.context = context;
        this.mylist = mylist;
    }

    @NonNull
    @Override
    public view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.previous_anal_item,parent,false);
        view_holder view_holder =new view_holder(view);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull view_holder holder, int position) {
         holder.date.setText(mylist.get(position).getDate());
         holder.result.setText(mylist.get(position).getResult());

         //SET ON CLICK LISTNERS
        holder.view.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.previous_details_item)
        {
            analyze_details analyze_details = new analyze_details();
            analyze_details.show(((AppCompatActivity)context).getSupportFragmentManager(),"analyze_details");
        }
    }

    public class view_holder extends RecyclerView.ViewHolder{
        TextView date,result;
        CardView view;
        public view_holder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.date);
            result = itemView.findViewById(R.id.result);
            view = itemView.findViewById(R.id.previous_details_item);
        }
    }
}
