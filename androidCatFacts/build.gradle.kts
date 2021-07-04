plugins {
    id("com.android.application")
    kotlin("android")
}

dependencies {
    val build_gradle_version = "7.1.0-alpha02"
    val kotlin_gradle_plugin_version = "1.5.10"
    val appcompat_version = "1.3.0"
    val hilt_version = "2.37"
    val hilt_navigation_compose_version = "1.0.0-alpha03"
    val compose_activity_version = "1.3.0-beta02"
    val compose_version = "1.0.0-beta09"
    val compose_navigation_version = "2.4.0-alpha03"
    val material_version = "1.3.0"
    val room_version = "2.4.0-alpha03"
    val mockk_version = "1.11.0"
    val coroutines_test_version = "1.5.0"
    val truth_version = "1.1.3"
    val junit_version = "4.13.2"
    val kotlinter_version = "3.4.5"


    implementation(project(":shared"))

    implementation("androidx.appcompat:appcompat:$appcompat_version")
    implementation("androidx.activity:activity-compose:$compose_activity_version")

    implementation("com.google.android.material:material:$material_version")

    implementation("androidx.compose.ui:ui:$compose_version")
    implementation("androidx.compose.material:material:$compose_version")
    implementation("androidx.compose.ui:ui-tooling:$compose_version")
    implementation("androidx.compose.runtime:runtime:$compose_version")
    implementation("androidx.compose.animation:animation:$compose_version")
    implementation("androidx.compose.foundation:foundation:$compose_version")
    implementation("androidx.compose.compiler:compiler:$compose_version")
    implementation("androidx.navigation:navigation-compose:$compose_navigation_version")

    testImplementation("junit:junit:$junit_version")
    testImplementation("io.mockk:mockk:$mockk_version")
    testImplementation("com.google.truth:truth:$truth_version")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutines_test_version")
}

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.marinj.catfacts.android"
        minSdkVersion(23)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.0.0-beta09"
    }
}