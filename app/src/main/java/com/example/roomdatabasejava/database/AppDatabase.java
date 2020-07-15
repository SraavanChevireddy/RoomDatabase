package com.example.roomdatabasejava.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.roomdatabasejava.dao.ExamineeDAO;
import com.example.roomdatabasejava.entities.CaseListEntity;

@Database(entities = {CaseListEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ExamineeDAO examineeDAO();
}