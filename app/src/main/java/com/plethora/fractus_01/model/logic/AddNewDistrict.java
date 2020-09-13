package com.plethora.fractus_01.model.logic;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.plethora.fractus_01.R;
import com.plethora.fractus_01.graphical_display.graphical_model.home.ItemDistrict;
import com.plethora.fractus_01.graphical_display.graphical_model.home.DistrictAdapter;
import com.plethora.fractus_01.graphical_display.graphical_model.home.HomeActivity;
import com.plethora.fractus_01.model.District;
import com.plethora.fractus_01.model.Quarter;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class AddNewDistrict extends AppCompatActivity {

    static final int GALLERY_REQUEST = 1;

    private Bitmap bitmap;

    private ByteArrayOutputStream byteImage = new ByteArrayOutputStream();
    private Uri uri;
    private Button ok;
    private Button cancel;

    private DistrictAdapter districtAdapter;
    private RecyclerView recyclerView;

    private EditText txtDistrictName;
    private EditText txtRegionName;
    private EditText txtForestryName;
    private Button addSnapshot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_district);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        ok = (Button) findViewById(R.id.btn_ok);
        cancel = (Button) findViewById(R.id.btn_cancel);

        txtDistrictName = (EditText) findViewById(R.id.district_name);
        txtRegionName = (EditText) findViewById(R.id.region_name);
        txtForestryName = (EditText) findViewById(R.id.forestry_name);


        addSnapshot = (Button) findViewById(R.id.path_to_snapshot);
        addSnapshot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSearch();
            }
        });


        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AddNewDistrict.this, HomeActivity.class);

                try {

                    ItemDistrict itemDistrict = new ItemDistrict();
                    itemDistrict.setNameDistrict(txtDistrictName.getText().toString());
                    itemDistrict.setPreview(txtRegionName.getText().toString());
                    itemDistrict.setSubject(txtForestryName.getText().toString());
                    itemDistrict.setDate("7 aug");//TODO сделать нормальную дату

                    District district = new District(itemDistrict, new ArrayList<Quarter>());

                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteImage); // Разбираем битмап на байты
                    district.setBitmap(byteImage.toByteArray());  // добавляем байты в файл
                    FileOutputStream fos = new FileOutputStream(Environment.getExternalStorageDirectory() + "/"
                            + "Forestry_Districts" + "/" + txtDistrictName.getText().toString());
                    ObjectOutputStream oos = new ObjectOutputStream(fos);

                    oos.writeObject(district);
                    oos.flush();
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                startActivity(intent);


            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNewDistrict.this.finish();
                Intent intent = new Intent(AddNewDistrict.this, HomeActivity.class);
                startActivity(intent);
            }
        });
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case GALLERY_REQUEST:
                if (resultCode == RESULT_OK) {
                    uri = data.getData();
                    Toast.makeText(this, "Uri " + uri, Toast.LENGTH_LONG).show();
                    Toast.makeText(this, "Path " + uri.getPath(), Toast.LENGTH_LONG).show();
                    try {
                        bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        }
    }

    public void startSearch() {

        Intent photoPickerIntent = new Intent(Intent.ACTION_OPEN_DOCUMENT);   //ACTION_PICK - выбор файлового проводника
        photoPickerIntent.setType("image/*");
        // photoPickerIntent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(photoPickerIntent, GALLERY_REQUEST);

    }

}