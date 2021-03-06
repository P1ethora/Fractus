package com.plethora.fractus_01.model;

import com.plethora.fractus_01.fragmentsCard.circularSquares.CircularSquares;
import com.plethora.fractus_01.fragmentsCard.moreInformation.MoreInformation;
import com.plethora.fractus_01.fragmentsCard.structure.spinner.ElementRecyclerRow;
import com.plethora.fractus_01.fragmentsCard.structure.spinner.ElementRecyclerTier;
import com.plethora.fractus_01.graphical_display.graphical_model.listSection.RecyclerItemSection;

import java.io.Serializable;
import java.util.ArrayList;

public class Section implements Serializable {

    private static final long serialVersionUID = 99999000808844L;
private int number;
private int typeLand;
private long square;
private int orl;
private RecyclerItemSection recyclerItemSection;

private ArrayList <ElementRecyclerTier> tiers;

    private ArrayList<ElementRecyclerRow> listItemStructure;
//private ItemStructure itemStructure;

private MoreInformation moreInformation;
private CircularSquares circularSquares;


public Section(){}


    public RecyclerItemSection getRecyclerItemSection() {
        return recyclerItemSection;
    }

    public void setRecyclerItemSection(RecyclerItemSection recyclerItemSection) {
        this.recyclerItemSection = recyclerItemSection;
    }



}
