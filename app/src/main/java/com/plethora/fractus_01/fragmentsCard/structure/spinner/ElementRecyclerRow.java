package com.plethora.fractus_01.fragmentsCard.structure.spinner;

import java.io.Serializable;

public class ElementRecyclerRow implements Element, Serializable {

    private static final long serialVersionUID = 99999000808844L;
    private String coef;
    private String TypeTree;
    private String A;
    private String H;
    private String D;
    private String KLT;

    int numberInTier;

    private long id;

    @Override
    public String toString() {
        return "ElementRecyclerRow{" +
                "coef='" + coef + '\'' +
                ", TypeTree='" + TypeTree + '\'' +
                ", A='" + A + '\'' +
                ", H='" + H + '\'' +
                ", D='" + D + '\'' +
                ", KLT='" + KLT + '\'' +
                ", id=" + id +
                '}';
    }

    public ElementRecyclerRow(){}

    public ElementRecyclerRow(String coef, String TypeTree, String A, String H, String D, String KLT){
        this.coef = coef;
        this.TypeTree = TypeTree;
        this.A = A;
        this.H = H;
        this.D = D;
        this.KLT = KLT;

    }

    public ElementRecyclerRow createElement(long id){
        ElementRecyclerRow element_recycler_row = new ElementRecyclerRow();
        element_recycler_row.setCoef("");
        element_recycler_row.setTypeTree("");
        element_recycler_row.setA("");
        element_recycler_row.setH("");
        element_recycler_row.setD("");
        element_recycler_row.setKLT("");
        element_recycler_row.setId(id);
        return element_recycler_row;
    }

    public String getCoef() {
        return coef;
    }

    public void setCoef(String coef) {
        this.coef = coef;
    }

    public String getTypeTree() {
        return TypeTree;
    }

    public void setTypeTree(String typeTree) {
        TypeTree = typeTree;
    }

    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    public String getH() {
        return H;
    }

    public void setH(String h) {
        H = h;
    }

    public String getD() {
        return D;
    }

    public void setD(String d) {
        D = d;
    }

    public String getKLT() {
        return KLT;
    }

    public void setKLT(String KLT) {
        this.KLT = KLT;
    }

    @Override
    public int getType() {
        return Element.TYPE_ROW;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    public long getId() {
        return id;
    }

    @Override
    public int getCountRow() {
        return 0;
    }

    @Override
    public void setCountRow(int countRow) {

    }

    @Override
    public int getNumber() {
        return numberInTier;
    }

    @Override
    public void setNumber(int number) {
        this.numberInTier = number;

    }

    public void setId(long id) {
        this.id = id;
    }
}
