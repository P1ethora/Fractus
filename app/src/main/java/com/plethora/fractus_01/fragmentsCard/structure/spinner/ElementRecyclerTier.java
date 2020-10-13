package com.plethora.fractus_01.fragmentsCard.structure.spinner;

import java.io.Serializable;

public class ElementRecyclerTier implements Element, Serializable {

    private static final long serialVersionUID = 99999000808844L;

    private String nameTier;
    private int numberTier = 0;
    private long id;
    private int countRow;

    public ElementRecyclerTier createElement(){
        ElementRecyclerTier element_recycler_row = new ElementRecyclerTier();
        element_recycler_row.setName("");

        return element_recycler_row;
    }

    @Override
    public String toString() {
        return "ElementRecyclerTier{" +
                "nameTier='" + nameTier + '\'' +
                ", id=" + id +
                ", countRow=" + countRow +
                '}';
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int getType() {
        return Element.TYPE_TIER;
    }

    @Override
    public String getName() {
        return nameTier;
    }

    @Override
    public void setName(String name) {
        this.nameTier = name;
    }

    public int getCountRow() {
        return countRow;
    }

    public void setCountRow(int countRow) {
        this.countRow = countRow;
    }

    @Override
    public int getNumber() {
        return numberTier;
    }

    @Override
    public void setNumber(int number) {
        this.numberTier = number;

    }
}
