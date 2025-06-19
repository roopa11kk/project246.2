package com.example.project2462

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import com.example.project2462.Activity.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun cartButtonClick_opensCheckoutScreen() {
        // Click the Cart LinearLayout
        onView(withId(R.id.cartBtn)).perform(click())

        // Replace "Checkout" with a real heading or unique view from your checkout screen
        onView(withText("Checkout")).check(matches(isDisplayed()))
    }
}
