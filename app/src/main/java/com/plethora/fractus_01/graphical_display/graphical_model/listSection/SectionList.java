package com.plethora.fractus_01.graphical_display.graphical_model.listSection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.plethora.fractus_01.R;
import com.plethora.fractus_01.graphical_display.graphical_model.sectionMenu.SectionMenu;
import com.plethora.fractus_01.model.logic.SelectionState;
import com.plethora.fractus_01.model.Section;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

import java.io.IOException;
import java.util.ArrayList;

public class SectionList extends AppCompatActivity {

    private RecyclerView recyclerViewSection;
    private AdapterRecyclerSection adapterRecyclerSection;
    private ArrayList<Section> recyclerItemList;
    private FloatingActionButton fab;
    private SlidrInterface slidrInterface;

    private int forestryNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_list);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        slidrInterface = Slidr.attach(this);

            Toolbar toolbar = findViewById(R.id.toolbarSectionlist);
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

            recyclerViewSection = (RecyclerView) findViewById(R.id.recyclerViewSection);
            recyclerViewSection.setHasFixedSize(true);
            recyclerViewSection.setLayoutManager(new GridLayoutManager(this,4));

        fab = (FloatingActionButton) this.findViewById(R.id.fabSectionList);
        fab.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ShowToast")
            @Override
            public void onClick(View view) {
                Section section = new Section();
                section.setRecyclerItemSection(new RecyclerItemSection(String.valueOf(recyclerItemList.size()+1)));
                //recyclerItemList.add(section);
                forestryNumber = extras.getInt("numberQuarter");

                SelectionState.file.getListQuarters()
                        .get(forestryNumber)
                        .getListSections().add(section);
                try {
                    SelectionState.save();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                recyclerViewSection.scrollToPosition(recyclerItemList.size() - 1);

                Intent intent = new Intent(view.getContext(), SectionMenu.class);
                intent.putExtra("numQuarter",forestryNumber);
                intent.putExtra("numberSection", SelectionState.file.getListQuarters()
                        .get(forestryNumber).getListSections().indexOf(section));
                view.getContext().startActivity(intent);


            }
        });

/*
        recyclerViewSection.addOnScrollListener(new RecyclerView.OnScrollListener() {
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

        //if (extras.getString("number") != null)

            recyclerItemList = SelectionState.file.getListQuarters()
                    .get(extras.getInt("num"))
                    .getListSections();


            adapterRecyclerSection = new AdapterRecyclerSection(recyclerItemList,this);
            recyclerViewSection.setAdapter(adapterRecyclerSection);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            if (item.getItemId() == android.R.id.home) {
                this.finish();
                return true;
            }
            return super.onOptionsItemSelected(item);
        }

    }