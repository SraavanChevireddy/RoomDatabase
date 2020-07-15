package com.example.roomdatabasejava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import com.example.roomdatabasejava.database.AppDatabase;
import com.example.roomdatabasejava.entities.CaseListEntity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "AppDatabase.db").allowMainThreadQueries().build();

        // Code One
        CaseListEntity ent = new CaseListEntity();
        ent.caseNumber = 20040697;
        ent.examineeName = "Sraavan";
        ent.dateOfService = "Jul 15, 20";
        ent.reportDueDate = "Jul 20, 20";
        ent.extCaseNumber = 21034413;
        ent.serviceName = "IME";

        // Add Code One to database
        db.examineeDAO().insertAll(ent);

        // Fetching all the entities from database.
        List<CaseListEntity> entities = db.examineeDAO().getAll();
        for(CaseListEntity entity : entities){
            Log.d("Fetch","Examinee name is ---->" + entity.examineeName + "His Primay key is" + entity.caseNumber);
        }


    }
}