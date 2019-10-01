package com.rishabh.concetto2019.WorkshopPage.MVP;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rishabh.concetto2019.R;
import com.rishabh.concetto2019.WorkshopPage.Model.WorkshopModel;

import java.util.List;

public class WorkshopAdapter extends RecyclerView.Adapter<WorkshopAdapter.ViewHolder> {

    List<WorkshopModel> list;
    Context context;

    public WorkshopAdapter(List<WorkshopModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public WorkshopAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.card_workshop,parent,false);
        return new WorkshopAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull WorkshopAdapter.ViewHolder holder, int position) {
        holder.about.setText(list.get(position).getAbout());
       // holder.link.setText(list.get(position).getRegistration());
        holder.date.setText(list.get(position).getDate());
        holder.date.append("\n"+list.get(position).getTime());
       holder.location.setText(list.get(position).getLocation());
       // holder.name.setText(list.get(position).getName());
        holder.eventname.setText(list.get(position).getEventname());
        holder.link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(list.get(position).getRegistration()); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);
            }
        });




    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView about,date,eventname,name,time,location,link;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            about=itemView.findViewById(R.id.about);
            date = itemView.findViewById(R.id.time);
            location = itemView.findViewById(R.id.location);
            eventname= itemView.findViewById(R.id.event_name);
            link=itemView.findViewById(R.id.workshop_register);

        }
    }
}
