package com.example.project2462

import android.content.Context
import com.example.project2462.Domain.ItemsModel
import com.example.project2462.Helper.ManagmentCart
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class CartUnitTest {

    private lateinit var cartManager: ManagmentCart
    private lateinit var context: Context

    @Before
    fun setup() {
        context = Mockito.mock(Context::class.java)
        cartManager = ManagmentCart(context)
    }

    @Test
    fun testAddItemToCartIncreasesCartSize() {
        val item = ItemsModel(
            title = "Cappuccino",
            description = "Strong coffee with frothy milk",
            picUrl = arrayListOf("https://example.com/image.jpg"),
            price = 120.0,
            rating = 4.5,
            numberInCart = 1,
            extra = "Hot"
        )

        cartManager.insertItems(item)
        val result = cartManager.getListCart().size
        assertEquals(1, result)
    }
}
