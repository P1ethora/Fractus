package com.plethora.fractus_01.fragmentsCard.structure.spinner;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DataBase extends SQLiteOpenHelper {

    private Context context;

    public static final String DATABASE_NAME = "DataBaseFractus.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "type_tree";
    public static final String COLUMN_TREE = "tree_name";
    public static final String COLUMN_CODE = "tree_text_code";



    public DataBase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "CREATE TABLE " + TABLE_NAME + " (" +COLUMN_TREE + " TEXT, " + COLUMN_CODE +" TEXT);";
db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
onCreate(db);
    }
}
