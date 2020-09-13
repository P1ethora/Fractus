package com.plethora.fractus_01.fragmentsCard.undergrowth;

import java.io.Serializable;

public class ItemUndergrowth implements Serializable {

    private static final long serialVersionUID = 99999000808844L;

    private String textTypeTree;

    public ItemUndergrowth(String textTypeTree) {
        this.textTypeTree = textTypeTree;
    }

    public String getTextTypeTree() {
        return textTypeTree;
    }

    public void setTextTypeTree(String textTypeTree) {
        this.textTypeTree = textTypeTree;
    }
}
