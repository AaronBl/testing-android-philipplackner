package com.fintecimal.testandroidphilipplackner.data.local

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ShoppingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShopping(shoppingItem: ShoppingItem)

    @Delete
    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)

    @Query("Select * From shopping_items")
    fun observeAllShoppingItems(): LiveData<List<ShoppingItem>>

    @Query("Select SUM(price * amount) FROM shopping_items")
    fun observeTotalPrice() : LiveData<Float>
}