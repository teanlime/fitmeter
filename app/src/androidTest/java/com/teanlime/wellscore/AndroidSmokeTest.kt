package com.teanlime.wellscore

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.teanlime.wellscore.track.ui.TrackComposable.WEIGHT_INPUT
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
    val rule = createAndroidComposeRule<MainActivity>()

    val weightInput by lazy { rule.onNodeWithTag(WEIGHT_INPUT) }
    val incrementButton by lazy { rule.onNodeWithText("+") }
    val decrementButton by lazy { rule.onNodeWithText("-") }

    @Test
    fun verifyAndroidTestsRun() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.teanlime.wellscore", appContext.packageName)

        weightInput.assertIsDisplayed()
        incrementButton.assertIsDisplayed()
        decrementButton.assertIsDisplayed()

        incrementButton.performClick()
        weightInput.assertTextEquals("70.1")

        decrementButton.performClick()
        decrementButton.performClick()
        decrementButton.performClick()
        incrementButton.performClick()
        decrementButton.performClick()
        decrementButton.performClick()
        weightInput.assertTextEquals("69.7")

        assertNotNull(Purple80)
    }
}