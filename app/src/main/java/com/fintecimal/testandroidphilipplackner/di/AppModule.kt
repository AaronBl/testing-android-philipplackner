package com.fintecimal.testandroidphilipplackner.di

import android.content.Context
import androidx.room.Room
import com.fintecimal.testandroidphilipplackner.data.local.ShoppingItem
import com.fintecimal.testandroidphilipplackner.data.local.ShoppingItemDatabase
import com.fintecimal.testandroidphilipplackner.data.remote.PixabayAPI
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import com.fintecimal.testandroidphilipplackner.other.Constants
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideshoppingDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, ShoppingItemDatabase::class.java, Constants.DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideShoppingDao(database: ShoppingItemDatabase) = database.shoppingDao()

    @Singleton
    @Provides
    fun providePixabayApi() : PixabayAPI{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(PixabayAPI::class.java)
    }
}