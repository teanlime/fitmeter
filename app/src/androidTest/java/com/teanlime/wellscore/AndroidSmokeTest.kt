package com.teanlime.wellscore

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.teanlime.wellscore.track.ui.TrackComposable.WEIGHT_TEXT_FIELD_TAG
import com.teanlime.wellscore.ui.theme.Purple80
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class AndroidSmokeTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun verifyAndroidTestsRun() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.teanlime.wellscore", appContext.packageName)
        // Find the home screen view
        composeTestRule.onNodeWithText("Weight").assertIsDisplayed()

        val weightInput = composeTestRule.onNodeWithTag(WEIGHT_TEXT_FIELD_TAG).assertIsDisplayed()
        with(weightInput) {
            assertTextEquals("")
            performTextInput("100")
            assertTextEquals("100")
        }

        composeTestRule.onNodeWithText("Submit").assertIsDisplayed().performClick()
        weightInput.assertTextEquals("")

        assertNotNull(Purple80)
    }
}