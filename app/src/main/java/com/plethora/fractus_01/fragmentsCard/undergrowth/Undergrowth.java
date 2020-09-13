package com.plethora.fractus_01.fragmentsCard.undergrowth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.plethora.fractus_01.R;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Undergrowth extends AppCompatActivity implements Serializable {

    private static final long serialVersionUID = 99999000808844L;
    private SlidrInterface slidrInterface;

    private List<ItemUndergrowth> undergrowthList;
    transient private RecyclerView recyclerView;
    transient private AdapterUndergrowth adapter;
    SwipeMenuListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_undergrowth);
        slidrInterface = Slidr.attach(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_undergrowth);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        findViewById(R.id.fab_undergrowth_add).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ShowToast")
            @Override
            public void onClick(View view) {
                if (undergrowthList.size() == 3) {
                    Toast.makeText(getApplicationContext(),"Invalid value",Toast.LENGTH_LONG).show();
                } else {
                    undergrowthList.add(new ItemUndergrowth(""));
                    recyclerView.scrollToPosition(0);
                }
            }
        });

        undergrowthList = new ArrayList<>();

        ItemUndergrowth itemUndergrowth = new ItemUndergrowth("");

        undergrowthList.add(itemUndergrowth);


        adapter = new AdapterUndergrowth(this, undergrowthList);
        recyclerView.setAdapter(adapter);


        ItemTouchHelper helper = new ItemTouchHelper(
                new Undergrowth.ItemTouchHandler(0,
                        ItemTouchHelper.LEFT)
        );

        helper.attachToRecyclerView(recyclerView);

    }

    private class ItemTouchHandler extends ItemTouchHelper.SimpleCallback {

        public ItemTouchHandler(int dragDirs, int swipeDirs) {
            super(dragDirs, swipeDirs);
        }

        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            int from = viewHolder.getAdapterPosition();
            int to = target.getAdapterPosition();

            Collections.swap(adapter.getItemList(), from, to);
            adapter.notifyItemMoved(from, to);

            return true;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            adapter.getItemList().remove(viewHolder.getAdapterPosition());
            adapter.notifyItemRemoved(viewHolder.getAdapterPosition());
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}