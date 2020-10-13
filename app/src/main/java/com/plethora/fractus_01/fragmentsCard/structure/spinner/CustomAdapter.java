package com.plethora.fractus_01.fragmentsCard.structure.spinner;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;


public class CustomAdapter<T> extends ArrayAdapter<T> {
    private Context context;
    private int textViewResourceId;
    private List<String> objects;
    private static boolean flag = false;
    public CustomAdapter(Context context, int textViewResourceId,
                         List<String> list) {
        super(context, textViewResourceId, (List<T>) list);
        this.context = context;
        this.textViewResourceId = textViewResourceId;
        this.objects = objects;
    }

    /*@Override
    public int getCount() {
        return super.getCount()-2;
    }*/

}
