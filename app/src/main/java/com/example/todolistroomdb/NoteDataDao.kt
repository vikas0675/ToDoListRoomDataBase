package com.example.todolistroomdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


// only user data are declare
//Dao =  Data Access Object

@Dao
interface NoteDataDao {

    // data Insert And add Function
    @Insert
    fun addNote(addNewData : NoteTableModelClass )

    // user data fetch
    @Query("select * from note")
    fun getAllNotes (): List<NoteTableModelClass>

    // data update function
    @Update
    fun updateNote(updateNote : NoteTableModelClass)

    // data delete function
    @Delete
    fun deleteNote(deleteNote : NoteTableModelClass)



}