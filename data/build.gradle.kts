import Dependancies.CoreDependancies
import Dependancies.RoomDependancies.ROOM_Compiler
import Dependancies.RoomDependancies.ROOM_KTX
import Dependancies.RoomDependancies.ROOM_RUNTIME
import Dependancies.TestDependancies
import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")

}

android {
    compileSdk = DefaultConfig.compileSdk

    defaultConfig {
        minSdk = DefaultConfig.minSdk
        targetSdk = DefaultConfig.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {

        release {
            isMinifyEnabled = true
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
    implementation(project(":domain"))
    //test
    testImplementation(TestDependancies.JUNIT)
    androidTestImplementation(TestDependancies.EXT_JUNIT)
    androidTestImplementation(TestDependancies.ESPRESSO_CORE)
    //Room
    implementation(ROOM_RUNTIME)
    kapt(ROOM_Compiler)
    implementation(ROOM_KTX)
    //Retrofit
    implementation (Dependancies.RetrofitDependancy.RETROFIT)
    implementation (Dependancies.RetrofitDependancy.GSON)
    implementation ("com.google.code.gson:gson:2.8.6")
    //hilt
    implementation(HiltDependancies.HILT)
    annotationProcessor(HiltDependancies.HILT_COMPILER)
    //Corountines
    implementation(Dependancies.KotlinDependancies.COROUTINES)
    //mock
    testImplementation(TestDependancies.MOCKITO_CORE)
    testImplementation(TestDependancies.MOCK)
    testImplementation(TestDependancies.MOCKITO_KOTLIN)

}