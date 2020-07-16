package com.example.roomdatabasejava.database

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.roomdatabasejava.entities.CaseListEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class DatabaseManager(val context: Context){

    private val db = Room.databaseBuilder(
            context,AppDatabase::class.java, "ew_database.db").build()
    /**
     * This suspend function is called from a ApplicationContext.
     * This creates a new object for CaseListEntity in the Reference object.The onConflictStrategy in maintained during the Database creation.
     *
     * Method is called from the IO block of Coroutine.
     */
     private suspend fun addExamineeDAO(entity: CaseListEntity){
        db.examineeDAO().insertAll(entity)
    }

    private suspend fun deleteExamineeDAO(forEntity: CaseListEntity){
        db.examineeDAO().delete(forEntity)
    }

         fun performOperation(operations: Operations,forEntity: CaseListEntity){
            when(operations){
                Operations.Insert -> {
                    CoroutineScope(IO).launch {
                        addExamineeDAO(forEntity)
                    }
                }

                Operations.Delete -> {
                    CoroutineScope(IO).launch {
                        deleteExamineeDAO(forEntity)
                    }
                }

                else -> {
                    print("Falling back to default operation state.")
                }

            }
        }
}



enum class Operations{
    Insert, Delete, Update
}