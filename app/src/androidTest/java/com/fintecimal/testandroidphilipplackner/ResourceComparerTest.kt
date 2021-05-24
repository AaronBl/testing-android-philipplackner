package com.fintecimal.testandroidphilipplackner

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class ResourceComparerTest {

    private lateinit var resourceComparer : ResourceComparer

    @Before
    fun setUp(){
        resourceComparer = ResourceComparer()
    }


    @Test
    fun stringResourceSameAsGivenString_returnTrue() {

        val contex = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEquals(contex, R.string.app_name, "TestAndroidPhilippLackner")
        assertThat(result).isTrue()
    }

    @Test
    fun stringResourceDifferentAsGivenString_returnFlase() {

        val contex = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEquals(contex, R.string.app_name, "Hello world")
        assertThat(result).isFalse()
    }

}