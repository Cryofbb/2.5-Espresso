package ru.kkuzmichev.simpleappforespresso;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.os.Environment;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(AllureAndroidJUnit4.class)
//@RunWith(AndroidJUnit4.class)
public class Homework {
    @Before
    public void createAllureDir() {
        File path = new File(Environment.getExternalStorageDirectory().getAbsolutePath()
                + "/allure-results/"
        );
        if (!path.exists()) {
            path.mkdirs();
        }
    }
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void idCheckTest() {
        ViewInteraction mainText = onView(
                withId(R.id.text_home)
        );
        mainText.check(
                matches(
                        withText("This is home fragment")
                )
        );
    }
}
