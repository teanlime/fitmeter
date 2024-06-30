// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false

    // Add the dependency for the Google services Gradle plugin
    alias(libs.plugins.google.services) apply false

    alias(libs.plugins.ktlint) apply false

    alias(libs.plugins.kotlin.kapt) apply false

    alias(libs.plugins.kotlin.compose.compiler) apply false

    alias(libs.plugins.hilt) apply false
}