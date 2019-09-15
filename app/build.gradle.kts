import ie.otormaigh.pluto.toolbox.BuildConfig
import ie.otormaigh.pluto.toolbox.Deps

plugins {
  id("com.android.application")
  id("kotlin-android")
  id("kotlin-android-extensions")
}

android {
  compileSdkVersion(BuildConfig.compileSdk)
  defaultConfig {
    applicationId = "ie.otormaigh.pluto"
    minSdkVersion(BuildConfig.minSdk)
    targetSdkVersion(BuildConfig.targetSdk)
    versionCode = 1
    versionName = "0.1"
    the<BasePluginConvention>().archivesBaseName = "pluto-$versionName"
  }

  signingConfigs {
    getByName("debug") {
      storeFile = file("../signing/debug.keystore")
    }
  }

  buildTypes {
    named("debug").configure {
      signingConfig = signingConfigs.getByName("debug")
      applicationIdSuffix = ".debug"
    }

    named("release").configure {
      signingConfig = signingConfigs.getByName("debug")

      postprocessing.apply {
        proguardFiles("proguard-rules.pro")
        isRemoveUnusedResources = true
        isRemoveUnusedCode = true
        isOptimizeCode = true
        isObfuscate = true
      }
    }
  }

  dependencies {
    implementation(Deps.Library.kotlin.stdlib)
    implementation(Deps.Library.androidx.appcompat)
    implementation("androidx.core:core-ktx:1.2.0-alpha04")
  }
}