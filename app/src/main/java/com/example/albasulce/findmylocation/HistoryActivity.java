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
    public TextView tableContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        tableContent = (TextView) findViewById(R.id.textView1);
        DatabaseHelper l=new DatabaseHelper(getApplicationContext());
       tableContent.setText(l.viewAll()+"\n");

    }
                    }
                
