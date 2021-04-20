package com.example.mindyourpet.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

val DATABASE_NAME = "myData"
val TABLE_NAME = "AllPets"
val COL_NAME = "name"
val COL_ID ="PetId"
val COL_SpecieID ="SpeciesID"

class DataBaseHandler (context: Context) : SQLiteOpenHelper(context, DATABASE_NAME,null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        //create required tables here

        val createTable = "Create Table " + TABLE_NAME +" ( "+ COL_ID + "INTEGER PRIMARY KEY AUTOINCREMENT," + COL_NAME + "NAME," + COL_SpecieID+ "INTEGER";

        db?.execSQL(createTable)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(user : )
    {

    }


}
