package www.dm.com.Main_Screen.Scenario_messages.pattern;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import www.dm.com.Main_Screen.Scenario_messages.controller.Scenario_chat.chat;
import www.dm.com.Main_Screen.Scenario_messages.model.msg_list;
import www.dm.com.R;

public class messages_adapter extends RecyclerView.Adapter<messages_adapter.view_holder> implements View.OnClickListener {

    Context context;
    List<msg_list> mylist;

    public messages_adapter(Context context, List<msg_list> mylist) {
        this.context = context;
        this.mylist = mylist;
    }

    @NonNull
    @Override
    public view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.message_item,parent,false);
        view_holder view_holder =new view_holder(view);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull view_holder holder, int position) {
       holder.date.setText(mylist.get(position).getDate());
       holder.msg.setText(mylist.get(position).getMshg());
       holder.name.setText(mylist.get(position).getName());

       //SET ON CLICK ITEMS
        holder.view.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.view)
        {
         context.startActivity(new Intent(context, chat.class));
        }
    }

    public class view_holder extends RecyclerView.ViewHolder{
          TextView name,msg,date;
          LinearLayout view;
        public view_holder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            msg = itemView.findViewById(R.id.msg);
            date = itemView.findViewById(R.id.date);
            view =itemView.findViewById(R.id.view);
        }
    }
}
