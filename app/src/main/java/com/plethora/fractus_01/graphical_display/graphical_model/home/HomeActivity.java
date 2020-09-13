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

    private DistrictAdapter districtAdapter;
    private ActionMode actionMode;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private RecyclerView rv;
    private ArrayList<District> allDistricts;
    private ArrayList<ItemDistrict> allItemDistricts;
    private TextView numberFile;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        numberFile = (TextView) findViewById(R.id.numberFile); //helper
        createFolder();   //new folder


        numberFile.setText(String.valueOf(readFolder().size())); // check folder


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
        //districtAdapter = new DistrictAdapter(new ArrayList<ItemDistrict>(Emails.fakeEmails()));     //add list ItemDistrict from our folder

       // Intent intent = getIntent();
       // Bundle extras = intent.getExtras();

       /* if (extras.getString("name") != null) {
            ItemDistrict itemDistrict = ItemDistrict.DistrictBuilder.builder()
                    .setUser(extras.getString("name"))
                    .setSubject(extras.getString("region"))
                    .setPreview(extras.getString("forestry"))
                    .setDate(extras.getString("data"))
                    .build();

            districtAdapter.getItemDistricts().add(0, itemDistrict);
        }*/
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
                    List<District> itemDistricts = districtAdapter.getItemDistricts();
                    for (District itemDistrict : itemDistricts) {
                        if (itemDistrict.getItemDistrict().isSelected())
                            itemDistrict.getItemDistrict().setSelected(false);
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


            // AddNewDistrict addNewDistrict = new AddNewDistrict();
            // addNewDistrict.setEmailAdapter(emailAdapter);
            // addNewDistrict.setRecyclerView(rv);
            drawerLayout.closeDrawers();
            Intent intent = new Intent(this, AddNewDistrict.class);
            startActivity(intent);


            return true;
            //openDialog();
            //drawerLayout.closeDrawers();


        }
        return false;
    }



    private void createFolder() throws NullPointerException {

        File apkStorage = new File(
                Environment.getExternalStorageDirectory() + "/"
                        + "Forestry_Districts");

        if (!apkStorage.exists()) {

            apkStorage.mkdir();
        }
    }

    private ArrayList<District> readFolder() {
        allDistricts = new ArrayList<>();
        //ArrayList<ItemDistrict> itemDistricts = new ArrayList<>();

        File folder = new File(Environment.getExternalStorageDirectory() + "/"
                + "Forestry_Districts");

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

          /*  for(District district :allDistricts ){
                if(district!=null)
                itemDistricts.add(district.getItemDistrict());
            }*/

        }
        return allDistricts;
    }

    public static void hideSoftKeyboard(Context context, View view) {
        try {
            InputMethodManager inputMethodManager =
                    (InputMethodManager) context.getSystemService(
                            Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(
                    view.getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}