package com.plethora.fractus_01.fragmentsCard.events;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.plethora.fractus_01.R;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class AdapterEvents  extends RecyclerView.Adapter<AdapterEvents.EventsViewHolder> {

    private Context mCtx;
    private List<ItemEvents> itemList;


    public List<ItemEvents> getItemList() {
        return itemList;
    }


    public AdapterEvents(Context mCtx, List<ItemEvents> items) {
        this.mCtx = mCtx;
        this.itemList = items;
    }

    public AdapterEvents.EventsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.item_events, null);
        return new AdapterEvents.EventsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterEvents.EventsViewHolder holder, int position) {
        ItemEvents itemEvents = itemList.get(position);

        holder.number.setText(String.valueOf(itemEvents.getNumber()));
        holder.numberRTK.setText(String.valueOf(itemEvents.getNumberRTK()));

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class EventsViewHolder extends RecyclerView.ViewHolder {

        EditText number;
        EditText numberRTK;


        public EventsViewHolder(View itemView) {
            super(itemView);
            number = itemView.findViewById(R.id.number_item_events);
            numberRTK = itemView.findViewById(R.id.item_numberRTK_events);


        }
    }

}
