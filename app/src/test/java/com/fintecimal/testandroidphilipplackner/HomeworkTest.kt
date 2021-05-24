package com.fintecimal.testandroidphilipplackner

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import com.google.common.truth.Truth.assertThat

class HomeworkTest {
    lateinit var homewor: Homework

    @Before
    fun initUtils() {
        homewor = Homework
    }

    @Test
    fun fibonacciZeroAndOne() {

        val result = homewor.fib(0)
        assertEquals(result, 0)

        val result2 = homewor.fib(1)
        assertEquals(result2, 1)
    }

    @Test
    fun fibonacciAnyNumber() {
        val result = homewor.fib(5)
        assertEquals(result, 5)
    }

    @Test
    fun checkBracesAreSetCorrectly_returnFalseOrFalse() {

        val result = homewor.checkBraces("(Ok)")
        assertThat(result).isTrue()

    }


}