package com.plethora.fractus_01.fragmentsCard.underbrush;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.plethora.fractus_01.R;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class AdapterUnderbrush extends RecyclerView.Adapter<AdapterUnderbrush.UnderbrushViewHolder>{

    private Context mCtx;
    private List<ItemUnderbrush> itemList;

    public List<ItemUnderbrush> getItemList() {
        return itemList;
    }


    public AdapterUnderbrush(Context mCtx, List<ItemUnderbrush> items) {
        this.mCtx = mCtx;
        this.itemList = items;
    }

    public AdapterUnderbrush.UnderbrushViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.item_underbrush, null);
        return new AdapterUnderbrush.UnderbrushViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterUnderbrush.UnderbrushViewHolder holder, int position) {
        ItemUnderbrush itemUnderbrush = itemList.get(position);

        holder.coef.setText(String.valueOf(itemUnderbrush.getCoef()));
        holder.type.setText(String.valueOf(itemUnderbrush.getType()));

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class UnderbrushViewHolder extends RecyclerView.ViewHolder {

        EditText coef;
        EditText type;


        public UnderbrushViewHolder(View itemView) {
            super(itemView);
           coef = itemView.findViewById(R.id.coef_item_underbrush);
           type = itemView.findViewById(R.id.item_type_underbrush);


        }
    }

}
