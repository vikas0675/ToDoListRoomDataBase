package com.example.todolistroomdb

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// 1st setup call = SQLiteOpenHelper
// 2nd step select and tap DbHelperClass and select more action OR Implement
// create excel tables ROW & COLUM
// used more scope for null type data = p0?let { }
// 1st step  = "create table"  // 2nd step given table name = note  // 3rd step given table title  = title
// 4t step given table description = body

class DbHelpherClass (val context: Context ) : SQLiteOpenHelper(context, DB_NAME,null, DB_VERSION) {


    companion object {
        // DB INFO
        const val  DB_NAME = "noteDB"
        const val DB_VERSION = 1

        // TABLE INFO
        const val  TABLE_NAME = "note"
        const val  COLUMN_NOTE_ID = "noteId"
        const val  COLUMN_NOTE_TITLE = "title"
        const val  COLUMN_NOTE_DESCRIPTION_BODY = "body"

        // TABLE USER INFO
        const val TABLE_USER_NAME = "userName"
        const val TABLE_USER_EMAIL = "email"
        const val TABLE_USER_MOBILE_NO = "mobileNo"
        const val TABLE_USER_PASSWORD = "password"
        const val TABLE_USER_CONFIRM_PASSWORD = "confirmPassword"

    }



    override fun onCreate(db: SQLiteDatabase?) {
        db?.let {

            // Note Table
            it.execSQL("Create table $TABLE_NAME ($COLUMN_NOTE_ID integer primary key autoincrement , $COLUMN_NOTE_TITLE text, $COLUMN_NOTE_DESCRIPTION_BODY text)")
            // user table

        }
    }







    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

}