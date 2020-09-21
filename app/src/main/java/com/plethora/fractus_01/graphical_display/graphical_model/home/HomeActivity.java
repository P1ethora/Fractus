package com.plethora.fractus_01.graphical_display.graphical_model.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.plethora.fractus_01.model.logic.AddNewDistrict;
import com.plethora.fractus_01.R;
import com.plethora.fractus_01.model.District;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;


public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private String pathFolder = Environment.getExternalStorageDirectory() + "/"
                    + "Forestry_Districts";

    private DistrictAdapter districtAdapter;
    private ActionMode actionMode;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private RecyclerView rv;
    private ArrayList<District> allDistricts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        createFolder();   //new folder
        readFolder();

        drawerLayout = findViewById(R.id.drawer1);
        navigationView = findViewById(R.id.nav_view1);
        navigationView.setNavigationItemSelectedListener(this);

        Toolbar toolbar = findViewById(R.id.toolbarHome);
        setSupportActionBar(toolbar);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();

        rv = findViewById(R.id.recycler_view_main);


        districtAdapter = new DistrictAdapter(allDistricts);
        districtAdapter.notifyItemInserted(0);


        districtAdapter.setListener(new DistrictAdapter.EmailAdapterListener() {
            @Override
            public void onItemClick(int position) {
                enableActionMode(position);
            }

            @Override
            public void onItemLongClick(int position) {
                enableActionMode(position);
            }
        });

        rv.setAdapter(districtAdapter);
        rv.scrollToPosition(0);

    }


    private void enableActionMode(int position) {                                   //Активный туулбар при выделении
        if (actionMode == null)
            actionMode = startSupportActionMode(new ActionMode.Callback() {
                @Override
                public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                    mode.getMenuInflater().inflate(R.menu.menu_delete, menu);
                    return true;
                }

                @Override
                public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                    return false;
                }

                @Override
                public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                    if (item.getItemId() == R.id.action_delete) {
                        districtAdapter.deleteEmails();
                        //TODO delete file from folder
                        mode.finish();
                        return true;
                    }
                    return false;
                }

                @Override
                public void onDestroyActionMode(ActionMode mode) {
                    districtAdapter.selectedItems.clear();
                    List<District> districts = districtAdapter.getListDistricts();
                    for (District district : districts) {
                        if (district.isSelected())
                            district.setSelected(false);
                    }

                    districtAdapter.notifyDataSetChanged();
                    actionMode = null;
                }
            });

        districtAdapter.toggleSelection(position);
        final int size = districtAdapter.selectedItems.size();
        if (size == 0) {
            actionMode.finish();
        } else {
            actionMode.setTitle(size + "");
            actionMode.invalidate();
        }

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {                   //Добавляем поиск
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.menuNewDistrict) {
            drawerLayout.closeDrawers();
            Intent intent = new Intent(this, AddNewDistrict.class);
            startActivity(intent);
            return true;

        }
        return false;
    }



    private void createFolder() throws NullPointerException {

        File apkStorage = new File(pathFolder);
        if (!apkStorage.exists()) {
            apkStorage.mkdir();
        }
    }

    private void readFolder() {

        allDistricts = new ArrayList<>();
        File folder = new File(pathFolder);
        FileInputStream fis = null;
        ObjectInputStream oin = null;
        File[] fList = folder.listFiles();

        if (fList != null) {
            for (File f : fList) {
                try {
                    fis = new FileInputStream(f);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    oin = new ObjectInputStream(fis);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                District district = null;
                try {
                    if (oin != null) {
                        district = (District) oin.readObject();
                    }
                } catch (ClassNotFoundException | IOException e) {
                    e.printStackTrace();
                }

                    allDistricts.add(district);

            }
        }
    }
}