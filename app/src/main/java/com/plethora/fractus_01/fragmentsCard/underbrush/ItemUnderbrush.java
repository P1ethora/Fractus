package com.plethora.fractus_01.fragmentsCard.underbrush;

import java.io.Serializable;

public class ItemUnderbrush implements Serializable {

    private static final long serialVersionUID = 99999000808844L;

    private String coef;
    private String type;

    public ItemUnderbrush(String coef, String type) {
        this.coef = coef;
        this.type = type;
    }

    public String getCoef() {
        return coef;
    }

    public void setCoef(String coef) {
        this.coef = coef;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
