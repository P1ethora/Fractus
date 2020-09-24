package com.plethora.fractus_01.fragmentsCard.structure;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.plethora.fractus_01.R;
import com.plethora.fractus_01.SelectedAdapterListener;
import com.plethora.fractus_01.model.District;

import java.util.Collections;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TierAdapter extends RecyclerView.Adapter<TierAdapter.ItemViewHolder> {

    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private List<TierItemStructure> itemList;
    private StructureAdapter structureAdapter;
    private  TierItemStructure tierItemStructure;
    private Context mContext;
    private RecyclerView recyclerView;

    //private SelectedAdapterListener listener;
    private int currentSelectedPos;
    //final SparseBooleanArray selectedItems = new SparseBooleanArray();

    TierAdapter(List<TierItemStructure> itemList, RecyclerView recyclerView) {
        this.itemList = itemList;
        this.recyclerView = recyclerView;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item_tier, viewGroup, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int position) {

        mContext = itemViewHolder.rvSubItem.getContext();
        TierItemStructure itemTier = itemList.get(position);
        itemViewHolder.tvItemTitle.setText(itemTier.getItemTitle());

        // Create layout manager with initial prefetch item count
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                itemViewHolder.rvSubItem.getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        layoutManager.setInitialPrefetchItemCount(itemTier.getSubItems().size());


        structureAdapter = new StructureAdapter(itemTier.getSubItems());

        itemViewHolder.rvSubItem.setLayoutManager(layoutManager);
        itemViewHolder.rvSubItem.setAdapter(structureAdapter);
        itemViewHolder.rvSubItem.setRecycledViewPool(viewPool);



       /* if (itemTier.isSelected()) {
            //txtIcon.setBackground(oval(Color.rgb(26, 115, 233), txtIcon));
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(GradientDrawable.RECTANGLE);
            //gradientDrawable.setCornerRadius(32f);
            gradientDrawable.setColor(Color.rgb(232, 240, 253));
            itemViewHolder.itemView.setBackground(gradientDrawable);
        } else {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(GradientDrawable.RECTANGLE);
            //gradientDrawable.setCornerRadius(32f);
            gradientDrawable.setColor(Color.WHITE);
            itemViewHolder.itemView.setBackground(gradientDrawable);
        }*/


        itemViewHolder.menuPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(itemViewHolder.rvSubItem.getContext(), v);
                popupMenu.getMenuInflater().inflate(R.menu.menu_item_tier, popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.tier_delete:
                                tierItemStructure = new TierItemStructure(itemList.get(position).getItemTitle(),itemList.get(position).getSubItems());
                                deleteItemTier(v, position);
                                break;
                            case  R.id.tier_add_line:
                                ItemStructure newItemStructure = new ItemStructure();
                                newItemStructure.setA("");
                                newItemStructure.setCoef("");
                                newItemStructure.setD("");
                                newItemStructure.setH("");
                                newItemStructure.setKLT("");
                                newItemStructure.setTypeTree("");

                                itemList.get(position).getSubItems().add(newItemStructure);
                        }
                        return false;
                    }
                });
            }
        });

        /*itemViewHolder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
              //  if (selectedItems.size() > 0 && listener != null)
                //    listener.onItemClick(position);
               // itemViewHolder.cardView.setCardBackgroundColor(Color.GREEN);

            }
        });*/

       /* itemViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (listener != null)
                    listener.onItemLongClick(position);
                return true;
            }
        });

        if (currentSelectedPos == position) currentSelectedPos = -1;*/

    }

    private void deleteItemTier(View view, int position){

        itemList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,itemList.size());

        Snackbar.make(view, "Undo deletion of: " + tierItemStructure.getItemTitle(), Snackbar.LENGTH_LONG)
                .setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        itemList.add(position,tierItemStructure);
                        notifyItemInserted(position);
                        notifyItemRangeChanged(position,itemList.size());
                    }
                }).setActionTextColor(mContext.getResources().getColor(android.R.color.holo_blue_bright))
                .show();
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView tvItemTitle;
        private RecyclerView rvSubItem;
        private ImageView menuPop;
        private CardView cardView;


        ItemViewHolder(View itemView) {
            super(itemView);
            //rvSubItem = recyclerView;
            tvItemTitle = itemView.findViewById(R.id.tv_item_title);
            rvSubItem = itemView.findViewById(R.id.rv_sub_item);
            menuPop = itemView.findViewById(R.id.button_menu_tier);
            cardView = itemView.findViewById(R.id.tier_cardView);

            ItemTouchHelper helper = new ItemTouchHelper(
                    new TierAdapter.ItemTouchHandler(0,
                            ItemTouchHelper.LEFT)
            );

            helper.attachToRecyclerView(rvSubItem);

        }

    }

    public List<TierItemStructure> getItemList() {
        return itemList;
    }


    private class ItemTouchHandler extends ItemTouchHelper.SimpleCallback {

        public ItemTouchHandler(int dragDirs, int swipeDirs) {
            super(dragDirs, swipeDirs);
        }

        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            int from = viewHolder.getAdapterPosition();
            int to = target.getAdapterPosition();

            Collections.swap(structureAdapter.getItemList(), from, to);
            structureAdapter.notifyItemMoved(from, to);

            return true;
        }


        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            structureAdapter.getItemList().remove(viewHolder.getAdapterPosition());
            structureAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
        }
    }

   /* void toggleSelection(int position) {
        currentSelectedPos = position;
        if (selectedItems.get(position)) {
            selectedItems.delete(position);
            //listDistricts.get(position).getItemDistrict().setSelected(false);
            itemList.get(position).setSelected(false);
        } else {
            selectedItems.put(position, true);
            //listDistricts.get(position).getItemDistrict().setSelected(true);
            itemList.get(position).setSelected(true);
        }
        notifyItemChanged(position);
    }*/


  /*  public void setListener(SelectedAdapterListener listener) {
        this.listener = listener;
    }
*/



}