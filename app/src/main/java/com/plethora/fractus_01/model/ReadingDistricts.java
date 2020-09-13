package com.plethora.fractus_01.model;

import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ReadingDistricts {

    

    public ArrayList<District> readFile() {
        ArrayList<District> allDistricts = null;
        File folder = new File(Environment.getExternalStorageDirectory() + "/"
                + "Forestry_Districts");
        // Если это каталог
        FileInputStream fis = null;
        ObjectInputStream oin = null;
        File[] fList = folder.listFiles();

        if (fList != null) {
            for (File f : fList) {
                try {
                    fis = new FileInputStream(f);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    oin = new ObjectInputStream(fis);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                      District  district = (District) oin.readObject();
                    allDistricts.add(district);
                } catch (ClassNotFoundException | IOException e) {
                    e.printStackTrace();
                }
            }

        }



        return allDistricts;
    }

}
