package com.plethora.fractus_01.graphical_display.graphical_model.listSection;

import java.io.Serializable;

public class RecyclerItemSection implements Serializable {

    private static final long serialVersionUID = 99999000808844L;
    private String number;

    public RecyclerItemSection(){}

    public RecyclerItemSection(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
