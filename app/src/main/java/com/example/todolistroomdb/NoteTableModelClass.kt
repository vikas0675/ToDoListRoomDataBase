package com.example.todolistroomdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName = "note")
data class NoteTableModelClass(

    @PrimaryKey(autoGenerate = true)
    val userId : Int,

    @ColumnInfo(name = "task_Title")
    val taskTitle  : String,

    @ColumnInfo(name = "task_Description")
    val taskDesc : String,


)
