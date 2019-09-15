package ie.otormaigh.pluto.toolbox

object Deps {
  object Version {
    // org.jetbrains.kotlin
    const val kotlin = "1.3.50"
  }

  object Library {
    object kotlin {
      const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Version.kotlin}"
    }

    object androidx {
      const val appcompat = "androidx.appcompat:appcompat:1.1.0"
    }
  }
}