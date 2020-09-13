package com.plethora.fractus_01.fragmentsCard.modelTrees;

import java.io.Serializable;

public class ItemModelTree implements Serializable {

    private static final long serialVersionUID = 99999000808844L;
    private String name;
    private String age;
    private String height;
    private String diameter;

    public ItemModelTree(String name, String age, String height, String diameter) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.diameter = diameter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }
}
