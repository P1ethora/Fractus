package com.plethora.fractus_01;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import com.plethora.fractus_01.model.logic.SelectionState;

public class Snapshot extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snapshot);


        imageView = (ImageView) findViewById(R.id.imageView);

       // imageView = SelectionState.file.getImageView();
        imageView.setImageBitmap(BitmapFactory.decodeByteArray(SelectionState.file.getBitmap() , 0, SelectionState.file.getBitmap().length));

    }
}
