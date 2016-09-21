package com.example.albasulce.findmylocation;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{

        public static final String Database_Name="HistoryOfLocation.db";
        public static final String Table_Name="HistoryTable";
        public static final String Col_1="ID";
        public static final String Col_2="Latitude";
        public static final String Col_3="Longitude";
        public static final String Col_4="Temperature";
        SQLiteDatabase db;
        Cursor res;
        //Creates the database
        public DatabaseHelper(Context context) {
            super(context, Database_Name, null, 1);
        }
        //To create the table in database
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("Create table"+Table_Name+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,LATITUDE DOUBLE, LONGITUDE DOUBLE, TEMPERATURE DOUBLE");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists"+Table_Name);
        onCreate(db);
        }

       public void InsertData(double Latitude,double Longitude){
                SQLiteDatabase db=this.getReadableDatabase();
                ContentValues contentValues=new ContentValues();
                contentValues.put(Col_2,Latitude);
                contentValues.put(Col_3,Longitude);
                long newRowId=db.insert(Table_Name,null,contentValues);
        }


        public String viewAll() {

                String data = null;
                while (res.moveToNext()) {
                        String key = "Key is:"+ res.getString(0) + "\n";
                        String Latitude = "Latitude is:"+res.getString(1) + "\n";
                        String Longitude = "Longitude is:" + res.getString(2) + "\n";
                        data = key + Latitude + Longitude;

                }
                return data;
        }

    }

