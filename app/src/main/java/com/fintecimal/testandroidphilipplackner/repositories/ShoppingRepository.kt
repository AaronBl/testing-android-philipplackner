package com.fintecimal.testandroidphilipplackner.repositories

import androidx.lifecycle.LiveData
import com.fintecimal.testandroidphilipplackner.data.local.ShoppingItem
import com.fintecimal.testandroidphilipplackner.data.remote.responses.ImageResponse
import com.fintecimal.testandroidphilipplackner.other.Resource
import retrofit2.Response

interface ShoppingRepository {
    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)

    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)

    fun observeShoppingItem(): LiveData<List<ShoppingItem>>

    fun observeTotalPrice(): LiveData<Float>

    fun observeAllShoppingItems(): LiveData<List<ShoppingItem>>

    suspend fun searchForImage(imageQuery: String) : Resource<ImageResponse>

}