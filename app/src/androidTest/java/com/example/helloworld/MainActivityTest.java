package com.example.helloworld;

import androidx.test.rule.ActivityTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertFalse;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void helloWorldTextValueTest() {
        onView(withId(R.id.helloWorldTextField)).check(matches(withText(containsString("Hello World!"))));
    }
    @Test
    public void buttonCloseActionTest() {
        assertFalse(mActivityTestRule.getActivity().isDestroyed());
        onView(withId(R.id.btnCloseApp)).perform(click());
        assertTrue(mActivityTestRule.getActivity().isFinishing());
    }

}
