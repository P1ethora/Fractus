package com.plethora.fractus_01.fragmentsCard.modelTrees;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.plethora.fractus_01.R;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class AdapterModelTree  extends RecyclerView.Adapter<AdapterModelTree.ModelTreeViewHolder> {

    private Context mCtx;
    private List<ItemModelTree> itemList;


    public List<ItemModelTree> getItemList() {
        return itemList;
    }


    public AdapterModelTree(Context mCtx, List<ItemModelTree> items) {
        this.mCtx = mCtx;
        this.itemList = items;
    }

    public AdapterModelTree.ModelTreeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.item_model_tree, null);
        return new AdapterModelTree.ModelTreeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterModelTree.ModelTreeViewHolder holder, int position) {
        ItemModelTree itemEvents = itemList.get(position);

        holder.typeTree.setText(String.valueOf(itemEvents.getName()));
        holder.age.setText(String.valueOf(itemEvents.getAge()));
        holder.height.setText(String.valueOf(itemEvents.getHeight()));
        holder.diameter.setText(String.valueOf(itemEvents.getDiameter()));

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class ModelTreeViewHolder extends RecyclerView.ViewHolder {

        EditText typeTree;
        EditText age;
        EditText height;
        EditText diameter;


        public ModelTreeViewHolder(View itemView) {
            super(itemView);
            typeTree = itemView.findViewById(R.id.model_tree_type);
            age = itemView.findViewById(R.id.model_tree_age);
            height = itemView.findViewById(R.id.model_tree_height);
            diameter = itemView.findViewById(R.id.model_tree_diameter);


        }
    }

}
