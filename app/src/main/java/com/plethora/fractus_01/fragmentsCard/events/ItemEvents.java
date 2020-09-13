package com.plethora.fractus_01.fragmentsCard.events;

import java.io.Serializable;

public class ItemEvents implements Serializable {

    private static final long serialVersionUID = 99999000808844L;
    private String number;
    private String numberRTK;

    public ItemEvents(String number, String numberRTK) {
        this.number = number;
        this.numberRTK = numberRTK;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumberRTK() {
        return numberRTK;
    }

    public void setNumberRTK(String numberRTK) {
        this.numberRTK = numberRTK;
    }
}
