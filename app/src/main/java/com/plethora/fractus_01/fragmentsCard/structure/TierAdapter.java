package com.plethora.fractus_01.fragmentsCard.structure;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.plethora.fractus_01.R;

import java.util.Collections;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TierAdapter extends RecyclerView.Adapter<TierAdapter.ItemViewHolder> {

    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private List<TierItemStructure> itemList;
    private StructureAdapter structureAdapter;


    private RecyclerView recyclerView;

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
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
        TierItemStructure itemTier = itemList.get(i);
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
                                Toast.makeText(itemViewHolder.rvSubItem.getContext(), "Delete", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;
                    }
                });
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView tvItemTitle;
        private RecyclerView rvSubItem;
        private ImageView menuPop;


        ItemViewHolder(View itemView) {
            super(itemView);
            //rvSubItem = recyclerView;
            tvItemTitle = itemView.findViewById(R.id.tv_item_title);
            rvSubItem = itemView.findViewById(R.id.rv_sub_item);
            menuPop = itemView.findViewById(R.id.button_menu_tier);

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
}