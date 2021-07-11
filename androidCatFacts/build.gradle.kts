plugins {
    id("com.android.application")
    kotlin("android")
}

dependencies {
    val appcompatVersion = "1.3.0"
    val composeActivityVersion = "1.3.0-beta02"
    val composeVersion = "1.0.0-beta09"
    val composeNavigationVersion = "2.4.0-alpha03"
    val materialVersion = "1.3.0"
    val mockkVersion = "1.11.0"
    val coroutinesTestVersion = "1.5.0"
    val truthVersion = "1.1.3"
    val junitVersion = "4.13.2"
    val koinVersion = "3.1.2"

    implementation(project(":shared"))

    implementation("androidx.appcompat:appcompat:$appcompatVersion")
    implementation("androidx.activity:activity-compose:$composeActivityVersion")

    implementation("com.google.android.material:material:$materialVersion")

    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling:$composeVersion")
    implementation("androidx.compose.runtime:runtime:$composeVersion")
    implementation("androidx.compose.animation:animation:$composeVersion")
    implementation("androidx.compose.foundation:foundation:$composeVersion")
    implementation("androidx.compose.compiler:compiler:$composeVersion")
    implementation("androidx.navigation:navigation-compose:$composeNavigationVersion")

    implementation("io.insert-koin:koin-core:$koinVersion")
    implementation("io.insert-koin:koin-android:$koinVersion")
    implementation("io.insert-koin:koin-androidx-compose:$koinVersion")

    testImplementation("junit:junit:$junitVersion")
    testImplementation("io.mockk:mockk:$mockkVersion")
    testImplementation("com.google.truth:truth:$truthVersion")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesTestVersion")
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