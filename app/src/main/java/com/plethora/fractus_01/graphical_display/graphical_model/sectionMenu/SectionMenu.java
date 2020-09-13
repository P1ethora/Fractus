package com.plethora.fractus_01.graphical_display.graphical_model.sectionMenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.plethora.fractus_01.R;
import com.plethora.fractus_01.fragmentsCard.circularSquares.CircularSquares;
import com.plethora.fractus_01.fragmentsCard.description.Description;
import com.plethora.fractus_01.fragmentsCard.events.Events;
import com.plethora.fractus_01.fragmentsCard.modelTrees.ModelTrees;
import com.plethora.fractus_01.fragmentsCard.moreInformation.MoreInformation;
import com.plethora.fractus_01.fragmentsCard.structure.Structure;
import com.plethora.fractus_01.fragmentsCard.underbrush.Underbrush;
import com.plethora.fractus_01.fragmentsCard.undergrowth.Undergrowth;

public class SectionMenu extends AppCompatActivity {

    private Button btnStructure;
    private Button btnDescription;
    private Button btnUndergrowth;
    private Button btnUnderbrush;
    private Button btnEvents;
    private Button btnMoreInformation;
    private Button btnModelTrees;
    private Button btnCircularSquares;

    private int quarterNumber;
    private int sectionNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_menu);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        quarterNumber = extras.getInt("numQuarter");
        sectionNumber = extras.getInt("numberSection");

        btnStructure = (Button)findViewById(R.id.btnStructure);
        btnStructure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SectionMenu.this, Structure.class);
                intent.putExtra("numQuarter",sectionNumber);
                intent.putExtra("numQuarter",quarterNumber);

                startActivity(intent);
            }
        });

        btnDescription = (Button)findViewById(R.id.btnDescription);
        btnDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SectionMenu.this, Description.class);
                startActivity(intent);
            }
        });

        btnUndergrowth = (Button)findViewById(R.id.btnUndergrowth);
        btnUndergrowth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SectionMenu.this, Undergrowth.class);
                startActivity(intent);
            }
        });

        btnUnderbrush = (Button)findViewById(R.id.btnUnderbrush);
        btnUnderbrush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SectionMenu.this, Underbrush.class);
                startActivity(intent);
            }
        });

        btnEvents = (Button)findViewById(R.id.btnEvents);
        btnEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SectionMenu.this, Events.class);
                startActivity(intent);
            }
        });

        btnMoreInformation = (Button)findViewById(R.id.btnMoreInformation);
        btnMoreInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SectionMenu.this, MoreInformation.class);
                startActivity(intent);
            }
        });

        btnModelTrees = (Button)findViewById(R.id.btnModelTrees);
        btnModelTrees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SectionMenu.this, ModelTrees.class);
                startActivity(intent);
            }
        });

        btnCircularSquares = (Button)findViewById(R.id.btnCircularSquares);
        btnCircularSquares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SectionMenu.this, CircularSquares.class);
                startActivity(intent);
            }
        });

    }
}