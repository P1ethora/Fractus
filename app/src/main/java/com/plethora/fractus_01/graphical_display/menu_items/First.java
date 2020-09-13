package com.plethora.fractus_01.graphical_display.menu_items;
/*
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.plethora.basilisk_01.R;
import com.plethora.basilisk_01.fragmentsCard.circularSquares.CircularSquares;
import com.plethora.basilisk_01.fragmentsCard.description.Description;
import com.plethora.basilisk_01.fragmentsCard.events.Events;
import com.plethora.basilisk_01.fragmentsCard.modelTrees.ModelTrees;
import com.plethora.basilisk_01.fragmentsCard.moreInformation.MoreInformation;
import com.plethora.basilisk_01.fragmentsCard.structure.Structure;
import com.plethora.basilisk_01.fragmentsCard.underbrush.Underbrush;
import com.plethora.basilisk_01.fragmentsCard.undergrowth.Undergrowth;


public class First extends Fragment {

    private Button btnStructure;
    private Button btnDescription;
    private Button btnUndergrowth;
    private Button btnUnderbrush;
    private Button btnEvents;
    private Button btnMoreInformation;
    private Button btnModelTrees;
    private Button btnCircularSquares;

    public First() {}


    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        btnStructure = (Button)view.findViewById(R.id.btnStructure);
        btnStructure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Structure.class);
                startActivity(intent);
            }
        });

        btnDescription = (Button)view.findViewById(R.id.btnDescription);
        btnDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Description.class);
                startActivity(intent);
            }
        });

        btnUndergrowth = (Button)view.findViewById(R.id.btnUndergrowth);
        btnUndergrowth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Undergrowth.class);
                startActivity(intent);
            }
        });

        btnUnderbrush = (Button)view.findViewById(R.id.btnUnderbrush);
        btnUnderbrush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Underbrush.class);
                startActivity(intent);
            }
        });

        btnEvents = (Button)view.findViewById(R.id.btnEvents);
        btnEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Events.class);
                startActivity(intent);
            }
        });

        btnMoreInformation = (Button)view.findViewById(R.id.btnMoreInformation);
        btnMoreInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MoreInformation.class);
                startActivity(intent);
            }
        });

        btnModelTrees = (Button)view.findViewById(R.id.btnModelTrees);
        btnModelTrees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ModelTrees.class);
                startActivity(intent);
            }
        });

        btnCircularSquares = (Button)view.findViewById(R.id.btnCircularSquares);
        btnCircularSquares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CircularSquares.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
*/