plugins {
    id(Plugins.kotlinAndroid)
    id("maven-publish")
    id("com.android.library")
}

android {
    namespace = "com.himanshoe.pluck_model"
    compileSdk = ModuleExtension.compileSdkVersion

    defaultConfig {
        minSdk = ModuleExtension.DefaultConfigs.minSdkVersion
        targetSdk = ModuleExtension.DefaultConfigs.targetSdkVersion

        testInstrumentationRunner = ModuleExtension.DefaultConfigs.testInstrumentationRunner
        consumerProguardFiles(ModuleExtension.DefaultConfigs.defaultConsumerProguardFiles)
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(ModuleExtension.DefaultConfigs.defaultProguardOptimizeFileName),
                ModuleExtension.DefaultConfigs.proGuardRules
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = ModuleExtension.jvmTarget
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
}

dependencies {
    implementation(Deps.Compose.ui)
    implementation(Deps.Compose.materialYou)
    implementation(Deps.Compose.uiToolingPreview)
    implementation(Deps.Compose.activity)
    implementation(Deps.Compose.paging)
    implementation(Deps.Compose.activity)
    implementation(Deps.Compose.viewmodel)
    implementation("io.coil-kt:coil-compose:1.4.0")
    implementation(Deps.Accompanist.permission)
    implementation("androidx.paging:paging-common-ktx:3.1.0")

    debugApi(Deps.Compose.uiTooling)

    testImplementation(Deps.Test.jUnit)
    androidTestImplementation(Deps.AndroidTest.jUnitExtensions)
    androidTestImplementation(Deps.AndroidTest.espressoCore)
    androidTestApi(Deps.AndroidTest.uiTestJunit)
}
plugins.apply(Plugins.vanniktechPublish)

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.github.Yarik-Ydavik"
            artifactId = "pluck_model"
            version = "3.8"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}
