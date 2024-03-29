plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "dev.duprat.legacytraining"
    compileSdk = 34

    defaultConfig {
        applicationId = "dev.duprat.legacytraining"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // Android
    implementation(libs.android.core)
    implementation(libs.android.appCompat)
    implementation(libs.android.material)
    implementation(libs.android.constraintLayout)
    implementation(libs.android.flexbox)

    // Navigation
    implementation(libs.navigation.ui)
    implementation(libs.navigation.fragment)

    //Glide
    implementation(libs.glide)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)

    // Koin
    implementation(libs.koin)

    // Store
    implementation(libs.store)

    testImplementation(libs.junit)
    androidTestImplementation(libs.test.junit.android)
    androidTestImplementation(libs.test.espresso)
}