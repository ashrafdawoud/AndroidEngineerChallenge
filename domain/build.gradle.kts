plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}
dependencies {
    //test
    testImplementation(Dependancies.TestDependancies.JUNIT)
    //coroutines
    implementation(Dependancies.KotlinDependancies.COROUTINES)
}