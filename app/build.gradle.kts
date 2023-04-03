plugins {
    id(Plugins.application)
    id(Plugins.kotlinAndroid)
}

android {
    namespace = "com.himanshoe.app"
    compileSdk = ModuleExtension.compileSdkVersion

    defaultConfig {
        applicationId = "com.himanshoe.app"
        minSdk = ModuleExtension.DefaultConfigs.minSdkVersion
        targetSdk = ModuleExtension.DefaultConfigs.targetSdkVersion

        testInstrumentationRunner = ModuleExtension.DefaultConfigs.testInstrumentationRunner
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


    implementation(project(":pluck_model"))
    implementation(Deps.Compose.ui)
    implementation(Deps.Compose.materialYou)
    implementation(Deps.Compose.uiToolingPreview)
    implementation(Deps.Compose.activity)


    debugApi(Deps.Compose.uiTooling)

    testImplementation(Deps.Test.jUnit)
    androidTestImplementation(Deps.AndroidTest.jUnitExtensions)
    androidTestImplementation(Deps.AndroidTest.espressoCore)
    androidTestApi(Deps.AndroidTest.uiTestJunit)
}
