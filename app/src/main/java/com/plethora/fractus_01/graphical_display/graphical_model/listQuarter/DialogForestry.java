package com.plethora.fractus_01.graphical_display.graphical_model.listQuarter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.plethora.fractus_01.R;
import com.plethora.fractus_01.model.Quarter;
import com.plethora.fractus_01.model.Section;
import com.plethora.fractus_01.model.logic.SelectionState;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.recyclerview.widget.RecyclerView;

public class DialogForestry extends AppCompatDialogFragment {

    private EditText txtForestryNumber;
    private EditText category;
    private EditText administrativeRegion;
    private EditText radiation;
    private EditText relief;
    private Date date;



    private AdapterRecyclerQuarter adapter;
    private RecyclerView recyclerView;

    @Override
    public Dialog onCreateDialog(Bundle saveInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.layout_dialog, null);
        txtForestryNumber = view.findViewById(R.id.txtForestry_number);
        category = view.findViewById(R.id.txtCategory);
        administrativeRegion = view.findViewById(R.id.txtAdministrative_region);
        radiation = view.findViewById(R.id.txtRadiation);
        relief = view.findViewById(R.id.txtRelief);

        builder.setView(view).setTitle("Date")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })

                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Quarter quarter = new Quarter();
                        quarter.setRecyclerItemQuarter(new RecyclerItemQuarter(txtForestryNumber.getText().toString()));
                        quarter.setListSections(new ArrayList<Section>());

quarter.setForestCategory(Integer.parseInt(category.getText().toString()));
quarter.setAdministrativeRegion(Integer.parseInt(administrativeRegion.getText().toString()));
quarter.setRadioactivity(Long.parseLong(radiation.getText().toString()));
quarter.setRelief(relief.getText().toString());
//quarter.setData("5 jun");

                        SelectionState.file.getListQuarters().add(quarter);
                        try {
                            SelectionState.save();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                       // adapter.notifyItemInserted(0);
recyclerView.scrollToPosition(SelectionState.file.getListQuarters().size()-1);
dialog.cancel();

                    }
                });
        return builder.create();
    }



    public void setAdapter(AdapterRecyclerQuarter adapter) {
        this.adapter = adapter;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }
}
