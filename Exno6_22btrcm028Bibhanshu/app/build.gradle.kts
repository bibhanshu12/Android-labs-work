plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.bibo.exno6_22btrcm028bibhanshu"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.bibo.exno6_22btrcm028bibhanshu"
        minSdk = 25
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
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.firebase.crashlytics.buildtools)
    testImplementation(libs.junit)
    implementation(libs.httpclient)
    implementation(libs.okhttp)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)




}