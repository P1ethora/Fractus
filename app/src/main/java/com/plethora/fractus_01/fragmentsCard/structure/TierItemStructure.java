package com.plethora.fractus_01.fragmentsCard.structure;

import android.content.ClipData;

import java.util.List;

public class TierItemStructure {
    private String itemTitle;
    private List<ItemStructure> subItems;

    public TierItemStructure(String itemTitle, List<ItemStructure> subItems) {
        this.itemTitle = itemTitle;
        this.subItems = subItems;
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
}
