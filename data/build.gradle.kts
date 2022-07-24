import Dependancies.CoreDependancies
import Dependancies.RoomDependancies.ROOM_Compiler
import Dependancies.RoomDependancies.ROOM_KTX
import Dependancies.RoomDependancies.ROOM_RUNTIME
import Dependancies.TestDependancies
import RetrofitDependancy.GSON
import RetrofitDependancy.RETROFIT
import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 24
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {
    //test
    testImplementation(TestDependancies.JUNIT)
    androidTestImplementation(TestDependancies.EXT_JUNIT)
    androidTestImplementation(TestDependancies.ESPRESSO_CORE)
    //Room
    implementation(ROOM_RUNTIME)
    annotationProcessor(ROOM_Compiler)
    implementation(ROOM_KTX)
    kapt(ROOM_Compiler)
    //Retrofit
    implementation (RETROFIT)
    implementation (GSON)
    //hilt
    implementation(HiltDependancies.HILT)
    kapt(HiltDependancies.HILT_COMPILER)

}