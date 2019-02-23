repositories {
  jcenter()
}

plugins {
  `kotlin-dsl`
  `java-gradle-plugin`
  id("com.gradle.plugin-publish") version "0.10.1"
}

group = "ie.otormaigh.pluto"
version = "0.1-${System.currentTimeMillis()}"

gradlePlugin {
  plugins {
    create("pluto") {
      id = "ie.otormaigh.pluto"
      implementationClass = "ie.otormaigh.pluto.plugin.PlutoPlugin"
    }
  }
}

pluginBundle {
  website = "https://otormaigh.ie"
  vcsUrl = "https://github.com/otormaigh/pluto-android"
  description = "A Gradle plugin toolbox containing helper functions and tasks."

  (plugins) {
    "pluto" {
      displayName = "Pluto"
      tags = listOf("pluto", "toolbox", "kotlin")
    }
  }
}