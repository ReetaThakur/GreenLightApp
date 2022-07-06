package com.example.greenlightapp.database

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addListOfItems(newsDbTable: ArrayList<ItemTable>)

    @Query("select * from item_table")
    fun getResponseFromDb(): LiveData<List<ItemTable>>

    @Query("delete from item_table")
    fun delete()
}