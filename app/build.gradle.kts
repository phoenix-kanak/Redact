plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.redact"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.redact"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.runtime.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation(libs.ui)
    implementation(libs.androidx.material)
    implementation(libs.ui.tooling.preview)
    implementation(libs.androidx.foundation)
    implementation(libs.ui.graphics)

    //glide
    implementation(libs.glide)
    annotationProcessor(libs.compiler)
    implementation(libs.androidx.ui.v140)
    implementation(libs.material3)

    implementation("androidx.navigation:navigation-compose:2.8.0")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    implementation("androidx.hilt:hilt-navigation-fragment:1.0.0")

    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-android-compiler:2.48")


    // Jetpack Compose ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")

    // Optional: LiveData integration with Compose (if needed)
    implementation ("androidx.lifecycle:lifecycle-livedata-compose:2.6.2")

    // For Kotlin Coroutines support with ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")

    // For image picking and camera access
    implementation ("androidx.activity:activity-ktx:1.8.0")
    implementation ("androidx.camera:camera-core:1.2.0")
    implementation ("androidx.camera:camera-camera2:1.2.0")
    implementation ("androidx.camera:camera-lifecycle:1.2.0")
    implementation ("androidx.camera:camera-view:1.2.0")

}