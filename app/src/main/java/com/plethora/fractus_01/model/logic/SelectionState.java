package com.plethora.fractus_01.model.logic;

import android.os.Environment;

import com.plethora.fractus_01.model.District;
import com.plethora.fractus_01.model.Section;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SelectionState {

    public static District file;

    public static int selectQuarter;
    public static int selectSection;


public static void save() throws IOException {

    String path = Environment.getExternalStorageDirectory() + "/"
            + "Forestry_Districts" + "/" + file.getNameDistrict();

    FileOutputStream fos = new FileOutputStream(path);
    ObjectOutputStream oos = new ObjectOutputStream(fos);

    oos.writeObject(file);
    oos.flush();
    oos.close();

}

}
