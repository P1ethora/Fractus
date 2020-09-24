package com.plethora.fractus_01.model;

import java.io.Serializable;
import java.util.ArrayList;

public class District implements Serializable {

    private String nameDistrict;
    private String subject;
    private String preview;
    private String date;
    private boolean selected;

    private static final long serialVersionUID = 99999000808844L;
    private ArrayList<Quarter> listQuarters;
    private byte[] bitmap;

    public District(){}

    public District(ArrayList<Quarter> listQuarters) {

        this.listQuarters = listQuarters;
    }


   /* public ItemDistrict getItemDistrict() {
        return itemDistrict;
    }*/

    /*public void setItemDistrict(ItemDistrict itemDistrict) {
        this.itemDistrict = itemDistrict;
    }*/

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

    public String getNameDistrict() {
        return nameDistrict;
    }

    public void setNameDistrict(String nameDistrict) {
        this.nameDistrict = nameDistrict;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

}