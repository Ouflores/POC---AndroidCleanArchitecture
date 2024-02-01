plugins {
    alias(libs.plugins.com.android.application)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.org.jetbrains.kotlin.ksp)
}

apply (from = rootProject.file("base_module.gradle"))

android {
    namespace = "com.liverpool.mx.checkout"

    defaultConfig {
        applicationId = "com.liverpool.mx.checkout"
    }
    buildFeatures {
        viewBinding = true
    }
    packaging {
        jniLibs.excludes.add("META-INF/DEPENDENCIES")
    }
}

dependencies {
    implementation(projects.feature.myAccount.myAccountPresentation)
    //Android versions
    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}