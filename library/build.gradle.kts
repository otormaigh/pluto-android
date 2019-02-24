import com.novoda.gradle.release.PublishExtension

plugins {
  id("com.android.library")
  id("kotlin-android")
}
android {
  compileSdkVersion(28)
  defaultConfig {
    minSdkVersion(21)
    targetSdkVersion(28)
    versionCode = 1
    versionName = "0.1"
  }

  buildTypes {
    named("release").configure {

      postprocessing.apply {
        consumerProguardFiles("proguard-rules.pro")
        isRemoveUnusedResources = false
        isRemoveUnusedCode = true
        isOptimizeCode = true
        isObfuscate = true
      }
    }
  }
}

dependencies {
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.21")
  implementation("androidx.appcompat:appcompat:1.0.2")
}

apply<ie.otormaigh.pluto.plugin.PlutoLocalPlugin>()
configure<PublishExtension> {
  artifactId = "pluto"
}
