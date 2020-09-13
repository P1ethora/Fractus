package com.plethora.fractus_01.fragmentsCard.structure;

import java.util.Arrays;
import java.util.List;

public class StructureItems {


    public static List<ItemStructure> fakeItems() {
        return Arrays.asList(

                ItemStructure.ItemStructureBuilder.builder()
                        .setYarus("1")
                        .setCoef("8")
                        .setTypeTree("C")
                        .setA("60")
                        .setH("27")
                        .setD("26")
                        .setKLT("1")
                        .build(),

                ItemStructure.ItemStructureBuilder.builder()
                        .setYarus("1")
                        .setCoef("2")
                        .setTypeTree("E")
                        .setA("60")
                        .setH("27")
                        .setD("26")
                        .setKLT("1")
                        .build(),

                ItemStructure.ItemStructureBuilder.builder()
                        .setYarus("1")
                        .setCoef("")
                        .setTypeTree("Б")
                        .setA("40")
                        .setH("24")
                        .setD("230")
                        .setKLT("2")
                        .build()

        );
    }
}
