import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)

    id("app.cash.sqldelight") version "2.1.0"
    kotlin("plugin.serialization") version "2.2.0"
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    
    sourceSets {
        
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)

            implementation("io.ktor:ktor-client-android:3.0.1")

            implementation("io.insert-koin:koin-android:4.0.3")

            implementation("app.cash.sqldelight:android-driver:2.1.0")
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.materialIconsExtended)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtimeCompose)

            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.1")

            //Ktor
            implementation("io.ktor:ktor-client-core:3.0.1")
            implementation("io.ktor:ktor-serialization-kotlinx-json:3.0.1")
            implementation("io.ktor:ktor-client-content-negotiation:3.0.1")
            implementation("io.ktor:ktor-client-logging:3.0.1")

            //Navigation
            implementation("org.jetbrains.androidx.navigation:navigation-compose:2.9.0-beta03")

            //Coil
            implementation("io.coil-kt.coil3:coil-compose:3.2.0")
            implementation("io.coil-kt.coil3:coil-network-ktor3:3.2.0")

            //Koin
            implementation("io.insert-koin:koin-core:4.0.3")
            implementation("io.insert-koin:koin-compose:4.0.3")
            implementation("io.insert-koin:koin-compose-viewmodel:4.0.3")

            implementation("com.russhwolf:multiplatform-settings:1.2.0")

            implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.6.1")

        }
        iosMain.dependencies {
            implementation("io.ktor:ktor-client-darwin:3.0.1")
            implementation("app.cash.sqldelight:native-driver:2.1.0")
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.odougle.recipeapp"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.odougle.recipeapp"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
}

sqldelight {
    databases {
        create("RecipeAppCmpAppDb") {
            packageName.set("com.odougle.recipeapp")
            generateAsync.set(true)
        }
    }
}