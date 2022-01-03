package com.example.businessplannerio;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Context;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Rule
    public ActivityScenarioRule rule = new ActivityScenarioRule<>(MainActivity.class);
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.businessplannerio", appContext.getPackageName());
    }

    @Test

    public void qualificationRecycleViewVisible(){
      onView(withId(R.id.qualificationRecyclerView)).check(matches(isDisplayed()));
    }

    @Test
    public void NavigationToBusinessFragment(){
        onView(withId(R.id.qualificationRecyclerView))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.businessFragmentLayout)).check(matches(isDisplayed()));
    }
    @Test
    public void NavigationToLawFragment(){
        onView(withId(R.id.qualificationRecyclerView))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));
        onView(withId(R.id.lawFragmentLayout)).check(matches(isDisplayed()));
    }
    @Test
    public void NavigationToMarketingFragment(){
        onView(withId(R.id.qualificationRecyclerView))
                .perform(RecyclerViewActions.actionOnItemAtPosition(2, click()));
        onView(withId(R.id.marketingFragmentLayout)).check(matches(isDisplayed()));
    }
    @Test
    public void NavigationToEconomyFragment(){
        onView(withId(R.id.qualificationRecyclerView))
                .perform(RecyclerViewActions.actionOnItemAtPosition(3, click()));
        onView(withId(R.id.economyFragmentLayout)).check(matches(isDisplayed()));
    }
    @Test
    public void NavigationToSaleFragment(){
        onView(withId(R.id.qualificationRecyclerView))
                .perform(RecyclerViewActions.actionOnItemAtPosition(4, click()));
        onView(withId(R.id.salesFragmentLayout)).check(matches(isDisplayed()));
    }



}