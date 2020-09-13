package com.plethora.fractus_01.model;

import com.plethora.fractus_01.graphical_display.graphical_model.listQuarter.RecyclerItemQuarter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Quarter implements Serializable {
    private static final long serialVersionUID = 99999000808844L;

    private int number;
    private int forestCategory;
    private int administrativeRegion;
    private long radioactivity;
    private String relief;
    private Date creationDate;
    private ArrayList<Section> listSections;

    private RecyclerItemQuarter recyclerItemQuarter;

    public RecyclerItemQuarter getRecyclerItemQuarter() {
        return recyclerItemQuarter;
    }

    public void setRecyclerItemQuarter(RecyclerItemQuarter recyclerItemQuarter) {
        this.recyclerItemQuarter = recyclerItemQuarter;
    }


    public Quarter(){}

    public Quarter(int number,
                   int forestCategory,
                   int administrativeRegion,
                   long radioactivity,
                   String relief,
                   Date creationDate,
                   ArrayList<Section> listSections) {

        this.number = number;
        this.forestCategory = forestCategory;
        this.administrativeRegion = administrativeRegion;
        this.radioactivity = radioactivity;
        this.relief = relief;
        this.creationDate = creationDate;
        this.listSections = listSections;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getForestCategory() {
        return forestCategory;
    }

    public void setForestCategory(int forestCategory) {
        this.forestCategory = forestCategory;
    }

    public int getAdministrativeRegion() {
        return administrativeRegion;
    }

    public void setAdministrativeRegion(int administrativeRegion) {
        this.administrativeRegion = administrativeRegion;
    }

    public long getRadioactivity() {
        return radioactivity;
    }

    public void setRadioactivity(long radioactivity) {
        this.radioactivity = radioactivity;
    }

    public String getRelief() {
        return relief;
    }

    public void setRelief(String relief) {
        this.relief = relief;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public ArrayList<Section> getListSections() {
        return listSections;
    }

    public void setListSections(ArrayList<Section> listSections) {
        this.listSections = listSections;
    }
}
