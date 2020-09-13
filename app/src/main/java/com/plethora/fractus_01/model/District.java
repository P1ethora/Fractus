package com.plethora.fractus_01.model;

import com.plethora.fractus_01.graphical_display.graphical_model.home.ItemDistrict;

import java.io.Serializable;
import java.util.ArrayList;

public class District implements Serializable {

    private static final long serialVersionUID = 99999000808844L;
    private ItemDistrict itemDistrict;
    private ArrayList<Quarter> listQuarters;
    private byte[] bitmap;

    public District(){}

    public District(ItemDistrict itemDistrict,
                    ArrayList<Quarter> listQuarters) {

        this.itemDistrict = itemDistrict;
        this.listQuarters = listQuarters;
    }


    public ItemDistrict getItemDistrict() {
        return itemDistrict;
    }

    public void setItemDistrict(ItemDistrict itemDistrict) {
        this.itemDistrict = itemDistrict;
    }

    public ArrayList<Quarter> getListQuarters() {
        return listQuarters;
    }

    public void setListQuarters(ArrayList<Quarter> listQuarters) {
        this.listQuarters = listQuarters;
    }

    public byte[] getBitmap() {
        return bitmap;
    }

    public void setBitmap(byte[] bitmap) {
        this.bitmap = bitmap;
    }

}