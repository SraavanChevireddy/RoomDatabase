package com.example.roomdatabasejava.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.roomdatabasejava.entities.CaseListEntity;

import java.util.List;

@Dao
public interface ExamineeDAO {
    @Query("SELECT * FROM CaseListEntity")
    List<CaseListEntity> getAll();

    @Query("SELECT * FROM caseListEntity WHERE caseNumber IN (:userIds)")
    List<CaseListEntity> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM caselistentity WHERE examineeName LIKE :first AND " +
            "serviceName LIKE :last LIMIT 1")
    CaseListEntity findByName(String first, String last);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(CaseListEntity... examinees);

    @Delete
    void delete(CaseListEntity examinee);
}


