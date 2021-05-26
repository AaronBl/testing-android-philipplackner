package com.fintecimal.testandroidphilipplackner.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fintecimal.testandroidphilipplackner.data.local.ShoppingItem
import com.fintecimal.testandroidphilipplackner.data.remote.responses.ImageResponse
import com.fintecimal.testandroidphilipplackner.other.Event
import com.fintecimal.testandroidphilipplackner.other.Resource
import com.fintecimal.testandroidphilipplackner.repositories.ShoppingRepository
import kotlinx.coroutines.launch

class ShoppingViewModel @ViewModelInject constructor(
    private val repository: ShoppingRepository
): ViewModel() {


    val shoppingItems=  repository.observeAllShoppingItems()
    val  totalTotalPrice = repository.observeTotalPrice()
    private val _images = MutableLiveData<Event<Resource<ImageResponse>>>()
    val image : LiveData<Event<Resource<ImageResponse>>> = _images

    private val _curImageUrl = MutableLiveData<String>()
    val curImageUrl: LiveData<String> = _curImageUrl

    private val _insertShoppingItemStatus = MutableLiveData<Event<Resource<ShoppingItem>>>()
    val insertShoppingItemStatus: LiveData<Event<Resource<ShoppingItem>>> = _insertShoppingItemStatus

    fun setCurImageUrl(url: String) {
        _curImageUrl.postValue(url)
    }

    fun deleteShoppingItem(shoppingItem: ShoppingItem) = viewModelScope.launch {
        repository.deleteShoppingItem(shoppingItem)
    }

    fun insertShoppingItemIntoDb(shoppingItem: ShoppingItem) = viewModelScope.launch {
        repository.insertShoppingItem(shoppingItem)
    }

    fun insertShoppingItem(name: String, amountString: String, priceString: String) {

    }

    fun searchForImage(imageQuery: String) {

    }

}