package com.example.roomdatabasejava.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CaseListEntity {
    @PrimaryKey
    public int caseNumber;

    @ColumnInfo(name = "extCaseNumber")
    public int extCaseNumber;

    @ColumnInfo(name = "examineeName")
    public String examineeName;

    @ColumnInfo(name = "serviceName")
    public String serviceName;

    @ColumnInfo(name = "dateOfService")
    public String dateOfService;

    @ColumnInfo(name = "reportDueDate")
    public String reportDueDate;
}
