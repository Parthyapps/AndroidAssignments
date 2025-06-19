// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false // Or libs.plugins.jetbrains.kotlin.android
    alias(libs.plugins.hilt) apply false        // Assuming you add Hilt to your version catalog
}