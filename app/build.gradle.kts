plugins {
  id("com.android.application")
  id("kotlin-android")
  id("kotlin-android-extensions")
}

android {
  compileSdkVersion(28)
  defaultConfig {
    applicationId = "ie.otormaigh.pluto"
    minSdkVersion(21)
    targetSdkVersion(28)
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
        isRemoveUnusedResources = false
        isRemoveUnusedCode = true
        isOptimizeCode = true
        isObfuscate = true
      }
    }
  }

  dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.21")
    implementation("androidx.appcompat:appcompat:1.0.2")
    implementation("androidx.core:core-ktx:1.0.1")
  }
}