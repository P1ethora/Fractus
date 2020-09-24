package com.plethora.fractus_01.fragmentsCard.structure;

import android.content.ClipData;

import java.util.ArrayList;
import java.util.List;

public class TierItemStructure {
    private String itemTitle;
    private List<ItemStructure> subItems;

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    private boolean selected;

    public TierItemStructure(String itemTitle, List<ItemStructure> subItems) {

        this.itemTitle = itemTitle;
        this.subItems = subItems;
        subItems.add(originItems());
        subItems.add(originItems());
    }

    private ItemStructure originItems (){

        ItemStructure itemStructure = new ItemStructure();

        itemStructure.setCoef("");
        itemStructure.setTypeTree("");
        itemStructure.setA("");
        itemStructure.setH("");
        itemStructure.setD("");
        itemStructure.setKLT("");


        return itemStructure;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public List<ItemStructure> getSubItems() {
        return subItems;
    }

    public void setSubItemList(List<ItemStructure> subItems) {
        this.subItems = subItems;
    }

    public void setSubItems(List<ItemStructure> subItems) {
        this.subItems = subItems;
    }
}
