package com.plethora.fractus_01.graphical_display.graphical_model.listQuarter;

import java.io.Serializable;

public class RecyclerItemQuarter implements Serializable {

    private static final long serialVersionUID = 99999000808844L;

    private String number;

    public RecyclerItemQuarter(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
