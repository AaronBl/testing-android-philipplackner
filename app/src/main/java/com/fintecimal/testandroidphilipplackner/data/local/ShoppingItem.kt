package com.fintecimal.testandroidphilipplackner.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_items")
data class ShoppingItem(
    var name: String,
    var amount: Int,
    var price: Float,
    var image: String,
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
)