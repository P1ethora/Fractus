package com.plethora.fractus_01.fragmentsCard.structure;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.plethora.fractus_01.R;
import com.plethora.fractus_01.model.logic.SelectionState;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Structure extends AppCompatActivity implements Serializable {

    private static final long serialVersionUID = 99999000808844L;
    private SlidrInterface slidrInterface;

    //a list to store all the products
    private ArrayList<ItemStructure> productList;
    private ArrayList<TierItemStructure> tierList;

    //the recyclerview
    transient private RecyclerView recyclerView;

    public RecyclerView getRecyclerView2() {
        return recyclerView2;
    }

    transient private RecyclerView recyclerView2;

    //transient private StructureAdapter adapter;
    transient private TierAdapter adapter;
    private SwipeMenuListView listView;
    private int quarterNumber;
    private int sectionNumber;
    private ActionMode actionMode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_structure2);
        slidrInterface = Slidr.attach(this);

        // Intent intent = getIntent();
        // Bundle extras = intent.getExtras();

        // quarterNumber = extras.getInt("numQuarter");
        // sectionNumber = extras.getInt("numberSection");

        //TODO нужна реализация яруса и открытие структуры согласно данным файла

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_structure);


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //recyclerView2.setHasFixedSize(true);
        //recyclerView2.setLayoutManager(new LinearLayoutManager(this));

        //productList = SelectionState.file.getListQuarters().get(quarterNumber).getListSections().get(sectionNumber).getListItemStructure();
        productList = new ArrayList<>();
        tierList = new ArrayList<>();
        findViewById(R.id.fab_structure_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ItemStructure itemStructure = new ItemStructure();

                //itemStructure.setYarus("");
                itemStructure.setCoef("");
                itemStructure.setTypeTree("");
                itemStructure.setA("");
                itemStructure.setH("");
                itemStructure.setD("");
                itemStructure.setKLT("");
                TierItemStructure tierItemStructure = new TierItemStructure("tier" +String.valueOf(tierList.size()+1),
                        new ArrayList<ItemStructure>());

               // productList.add(itemStructure);
                tierList.add(tierItemStructure);
                //SelectionState.file.getListQuarters().get(quarterNumber).getListSections().get(sectionNumber).getListItemStructure().add(itemStructure);
                try {
                    SelectionState.save();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //productList.add(itemStructure);
                recyclerView.scrollToPosition(0);
            }
        });


        // if (productList.size() == 0) {
        // if (SelectionState.file.getListQuarters().get(quarterNumber).getListSections().get(sectionNumber).getListItemStructure().size() == 0) {

        TierItemStructure tierItemStructure = new TierItemStructure("tier1", new ArrayList<ItemStructure>());
        tierList.add(tierItemStructure);
        //SelectionState.file.getListQuarters().get(quarterNumber).getListSections().get(sectionNumber).getListItemStructure().add(itemStructure);
        //SelectionState.file.getListQuarters().get(quarterNumber).getListSections().get(sectionNumber).getListItemStructure().add(itemStructure1);
        // productList.add(itemStructure);
        //productList.add(itemStructure1);


        //creating recyclerview adapter
        //adapter = new StructureAdapter(this, productList);
        adapter = new TierAdapter(tierList, getRecyclerView2());

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);


       /* ItemTouchHelper helper = new ItemTouchHelper(
                // below statement: used at move and sort
                // new ItemTouchHandler(ItemTouchHelper.UP | ItemTouchHelper.DOWN,
                //ItemTouchHelper.LEFT)
                new ItemTouchHandler(0,
                        ItemTouchHelper.LEFT)
        );

        helper.attachToRecyclerView(recyclerView);*/


    }

/*
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        try {
            SelectionState.save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/


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




}

