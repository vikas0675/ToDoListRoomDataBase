package com.example.todolistroomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [NoteTableModelClass::class], exportSchema = false, version = 1)
 abstract class MyRoomDataBase : RoomDatabase(){

     abstract fun NoteDataDao() : NoteDataDao

     companion object{

         // Name of data base
         const val DB_NAME = "noteDB"
          var DB_INSTANCE : MyRoomDataBase? = null

         fun getInstance(context: Context) :MyRoomDataBase {

             // initialize ROOM DB
             if (DB_INSTANCE==null){
                  DB_INSTANCE = Room.databaseBuilder(context, MyRoomDataBase::class.java, DB_NAME).build()
             }
             return DB_INSTANCE!!
         }

     }
}