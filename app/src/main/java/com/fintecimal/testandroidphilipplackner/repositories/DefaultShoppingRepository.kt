package com.fintecimal.testandroidphilipplackner.repositories

import androidx.lifecycle.LiveData
import com.fintecimal.testandroidphilipplackner.data.local.ShoppingDao
import com.fintecimal.testandroidphilipplackner.data.local.ShoppingItem
import com.fintecimal.testandroidphilipplackner.data.remote.PixabayAPI
import com.fintecimal.testandroidphilipplackner.data.remote.responses.ImageResponse
import com.fintecimal.testandroidphilipplackner.other.Resource
import dagger.internal.InjectedFieldSignature
import retrofit2.Response
import java.lang.Exception
import java.lang.reflect.Constructor
import javax.inject.Inject


class DefaultShoppingRepository @Inject constructor(
    private val shoppingDao: ShoppingDao,
    private val pixabayAPI: PixabayAPI
) : ShoppingRepository {
    override suspend fun insertShoppingItem(shoppingItem: ShoppingItem) {
        shoppingDao.insertShopping(shoppingItem)
    }

    override suspend fun deleteShoppingItem(shoppingItem: ShoppingItem) {
        shoppingDao.deleteShoppingItem(shoppingItem)
    }

    override fun observeShoppingItem(): LiveData<List<ShoppingItem>> {
        return shoppingDao.observeAllShoppingItems()
    }

    override fun observeTotalPrice(): LiveData<Float> {
        return  shoppingDao.observeTotalPrice()
    }

    override fun observeAllShoppingItems(): LiveData<List<ShoppingItem>> {
        return shoppingDao.observeAllShoppingItems()
    }

    override suspend fun searchForImage(imageQuery: String): Resource<ImageResponse> {
        return try {
            val response = pixabayAPI.searchForImage(imageQuery)
            if (response.isSuccessful) {
                response.body().let {
                    return@let Resource.success(it)
                } ?: Resource.error("Un error desconocido ocurrio", null)
            } else {
                Resource.error("An  unKnown error ocurred", null)
            }
        } catch (e: Exception) {
            Resource.error("Error al obtener los datos", null)
        }
    }

}