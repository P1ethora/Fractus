package com.plethora.fractus_01.fragmentsCard.structure;

import java.io.Serializable;

public class ItemStructure implements Serializable {

    private static final long serialVersionUID = 99999000808844L;
    private String yarus;
    private String coef;
    private String typeTree;
    private String A;
    private String H;
    private String D;
    private String KLT;
    private boolean stared;
    private boolean unread;
   // private boolean selected;

   /* public ItemStructure(String yarus,String coef,String typeTree, String A,String H,String D,String KLT){
        this.yarus = yarus;
        this.coef = coef;
        this.typeTree = typeTree;
        this.A = A;
        this.H = H;
        this.D = D;
        this.KLT = KLT;
    }*/


    public String getYarus() {
        return yarus;
    }

    public void setYarus(String yarus) {
        this.yarus = yarus;
    }


    public String getCoef() {
        return coef;
    }

    public void setCoef(String coef) {
        this.coef = coef;
    }


    public String getTypeTree() {
        return typeTree;
    }

    public void setTypeTree(String typeTree) {
        this.typeTree = typeTree;
    }


    public String getA() {
        return A;
    }

    public void setA(String A) {
        this.A = A;
    }


    public String getH() {
        return H;
    }

    public void setH(String H) {
        this.H = H;
    }


    public String getD() {
        return D;
    }

    public void setD(String D) {
        this.D = D;
    }


    public String getKLT() {
        return KLT;
    }

    public void setKLT(String KLT) {
        this.KLT = KLT;
    }



    public boolean isStared() {
        return stared;
    }

    public void setStared(boolean stared) {
        this.stared = stared;
    }


    public boolean isUnread() {
        return unread;
    }

    public void setUnread(boolean unread) {
        this.unread = unread;
    }


    /*public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }*/


    public static class ItemStructureBuilder {

        private String yarus;
        private String coef;
        private String typeTree;
        private String A;
        private String H;
        private String D;
        private String KLT;
        private boolean stared;
        private boolean unread;
        //private boolean selected;


        public ItemStructureBuilder setYarus(String yarus) {
            this.yarus = yarus;
            return this;
        }

        public ItemStructureBuilder setCoef(String coef) {
            this.coef = coef;
            return this;
        }

        public ItemStructureBuilder setTypeTree(String typeTree) {
            this.typeTree = typeTree;
            return this;
        }

        public ItemStructureBuilder setA(String A) {
            this.A = A;
            return this;
        }

        public ItemStructureBuilder setH(String H) {
            this.H = H;
            return this;
        }

        public ItemStructureBuilder setD(String D) {
            this.D = D;
            return this;
        }

        public ItemStructureBuilder setKLT(String KLT) {
            this.KLT = KLT;
            return this;
        }

        public ItemStructureBuilder setStared(boolean stared) {
            this.stared = stared;
            return this;
        }

        public ItemStructureBuilder setUnread(boolean unread) {
            this.unread = unread;
            return this;
        }
/*
        public EmailBuilder setSelected(boolean selected) {
            this.selected = selected;
            return this;
        }*/

        private ItemStructureBuilder() {}

        public static ItemStructureBuilder builder() {
            return new ItemStructureBuilder();
        }

        public ItemStructure build() {
            ItemStructure itemStructure = new ItemStructure();
            itemStructure.yarus = yarus;
            itemStructure.coef = coef;
            itemStructure.typeTree = typeTree;
            itemStructure.A = A;
            itemStructure.H = H;
            itemStructure.D = D;
            itemStructure.KLT = KLT;

            itemStructure.stared = stared;
            itemStructure.unread = unread;
            //itemStructure.selected = selected;
            return itemStructure;
        }

    }

}
