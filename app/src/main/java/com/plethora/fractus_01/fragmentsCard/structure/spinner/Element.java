package com.plethora.fractus_01.fragmentsCard.structure.spinner;

public interface Element {

    int TYPE_TIER = 0;
    int TYPE_ROW = 1;

    int getType();
    String getName();
    void setName(String name);
    long getId();
    int getCountRow();
    void setCountRow(int countRow);
    int getNumber();
    void setNumber(int number);

}
