package com.example.greenlightapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "item_table")
data class ItemTable(@ColumnInfo(name = "item")var item:String) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")var id:Int?=null
}