package com.fintecimal.testandroidphilipplackner.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fintecimal.testandroidphilipplackner.data.local.ShoppingItem
import com.fintecimal.testandroidphilipplackner.data.remote.responses.ImageResponse
import com.fintecimal.testandroidphilipplackner.other.Resource

class FakeShoppingRepository : ShoppingRepository {

    private val shoppingItems = mutableListOf<ShoppingItem>()

    private val observableShoppingItems = MutableLiveData<List<ShoppingItem>>(shoppingItems)

    private val observableTotalPrice = MutableLiveData<Float>()

    private var shouldReturnError = false

    fun setShouldReturnNetworkError(value: Boolean) {
        shouldReturnError = value
    }

    private fun refreshLiveData() {
        observableShoppingItems.postValue(shoppingItems)
        observableTotalPrice.postValue(getTotalPrice())
    }

    private fun getTotalPrice(): Float? {
        return shoppingItems.sumByDouble { it.price.toDouble() }.toFloat()
    }

    override suspend fun insertShoppingItem(shoppingItem: ShoppingItem) {
        shoppingItems.add(shoppingItem)
        refreshLiveData()
    }

    override suspend fun deleteShoppingItem(shoppingItem: ShoppingItem) {
        shoppingItems.remove(shoppingItem)
        refreshLiveData()
    }

    override fun observeShoppingItem(): LiveData<List<ShoppingItem>> {
        return observableShoppingItems
    }

    override fun observeTotalPrice(): LiveData<Float> {
        return observableTotalPrice
    }

    override fun observeAllShoppingItems(): LiveData<List<ShoppingItem>> {
        return observableShoppingItems
    }

    override suspend fun searchForImage(imageQuery: String): Resource<ImageResponse> {
            return  if(shouldReturnError){
                Resource.error("Error",null)
            }else{
                Resource.success(ImageResponse(listOf(),0,0))
            }
    }
}