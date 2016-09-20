package com.example.albasulce.findmylocation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HistoryActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    Cursor res;
    Button button_history;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        button_history=(Button)findViewById(R.id.button_his);
        viewAll();

    }
    public void viewAll(){
        button_history.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        StringBuffer buffer=new StringBuffer();
                        while(res.moveToNext()){
                            buffer.append("ID:"+res.getString(0)+"\n");
                            buffer.append("Latitude:"+res.getString(1)+"\n");
                            buffer.append("Longitude:"+res.getString(2)+"\n");
                        }
                    }
                }
        );
    }
   }
