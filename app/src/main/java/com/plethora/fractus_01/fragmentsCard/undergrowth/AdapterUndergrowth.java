package com.plethora.fractus_01.fragmentsCard.undergrowth;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.plethora.fractus_01.R;
import java.util.List;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterUndergrowth extends RecyclerView.Adapter<AdapterUndergrowth.UndergrowthViewHolder> {

    private Context mCtx;
    private List<ItemUndergrowth> itemList;

    public List<ItemUndergrowth> getItemList() {
        return itemList;
    }


    public AdapterUndergrowth(Context mCtx, List<ItemUndergrowth> items) {
        this.mCtx = mCtx;
        this.itemList = items;
    }

    public AdapterUndergrowth.UndergrowthViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.item_undergrowth, null);
        return new AdapterUndergrowth.UndergrowthViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterUndergrowth.UndergrowthViewHolder holder, int position) {
        ItemUndergrowth itemUndergrowth = itemList.get(position);

        holder.textTypeTree.setText(String.valueOf(itemUndergrowth.getTextTypeTree()));

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class UndergrowthViewHolder extends RecyclerView.ViewHolder {

        EditText textTypeTree;

        public UndergrowthViewHolder(View itemView) {
            super(itemView);
            textTypeTree = itemView.findViewById(R.id.type_tree_undergrowth);

        }
    }
}