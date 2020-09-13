package com.plethora.fractus_01.graphical_display.graphical_model.listQuarter;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.plethora.fractus_01.R;
import com.plethora.fractus_01.Snapshot;
import com.plethora.fractus_01.model.logic.SelectionState;
import com.plethora.fractus_01.model.Quarter;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NewForesty extends AppCompatActivity implements Serializable {

    private static final long serialVersionUID = 99999000808844L;

    private RecyclerView recyclerViewQuarter;
    private AdapterRecyclerQuarter adapterRecyclerQuarter;
    private List<Quarter> recyclerItemList;
    private FloatingActionButton fab;
    private SlidrInterface slidrInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district);

        slidrInterface = Slidr.attach(this);


        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);


        recyclerViewQuarter = (RecyclerView) findViewById(R.id.recyclerViewQuarter);
        recyclerViewQuarter.setHasFixedSize(true);
        recyclerViewQuarter.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerItemList = new ArrayList<>();

        fab = (FloatingActionButton) this.findViewById(R.id.fabQuarterList);
        fab.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ShowToast")
            @Override
            public void onClick(View view) {
                openDialog();
                //SelectionState.file.getListQuarters().add(quarter);

                recyclerViewQuarter.scrollToPosition(recyclerItemList.size() - 1);
            }
        });

/*
        recyclerViewQuarter.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

                if (dy < 0) {
// Recycle view scrolling up…
                    fab.show();
                } else if (dy > 0) {
                    fab.hide();
// Recycle view scrolling down…
                }
            }
        });*/
recyclerItemList = SelectionState.file.getListQuarters();

        adapterRecyclerQuarter = new AdapterRecyclerQuarter(recyclerItemList, this);
        recyclerViewQuarter.setAdapter(adapterRecyclerQuarter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        } else if (item.getItemId()== R.id.menu_district_snapshot) {
            Intent intent = new Intent(NewForesty.this, Snapshot.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.clear();//Добавляем меню в тулбар
        getMenuInflater().inflate(R.menu.menu_activity_district, menu);
        return true;
    }

    public void openDialog() {
        DialogForestry dialogForestry = new DialogForestry();
        dialogForestry.setAdapter(adapterRecyclerQuarter);
       dialogForestry.setRecyclerView(recyclerViewQuarter);
        dialogForestry.show(getSupportFragmentManager(), "Dialog Forestry");
    }

}