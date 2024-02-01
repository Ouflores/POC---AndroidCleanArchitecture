plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.org.jetbrains.kotlin.ksp)
}

apply (from = rootProject.file("base_module.gradle"))

android {
    namespace = "com.liverpool.mx.my_account_data"
    packaging { resources.excludes.add("META-INF/*") }
}

dependencies {
    implementation(projects.feature.myAccount.myAccountDomain)
    implementation(projects.core.coreNetwork)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}