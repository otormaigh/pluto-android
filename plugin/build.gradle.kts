import com.novoda.gradle.release.PublishExtension

repositories {
  jcenter()
}

buildscript {
  dependencies {
    classpath("com.novoda:bintray-release:0.9")
  }
}
apply<com.novoda.gradle.release.ReleasePlugin>()

plugins {
  `kotlin-dsl`
  `java-gradle-plugin`
  id("com.gradle.plugin-publish") version "0.10.1"
}

val NAME = "pluto"
val GROUP_ID = "ie.otormaigh.pluto"
val VERSION = "0.1-${System.currentTimeMillis()}"
val DESCRIPTION = "A Gradle plugin toolbox containing helper functions and tasks."
val WEBSITE = "https://otormaigh.ie"
val VCS_URL = "https://github.com/otormaigh/pluto-android"

group = GROUP_ID
version = VERSION

gradlePlugin {
  plugins {
    create(NAME) {
      id = GROUP_ID
      implementationClass = "ie.otormaigh.pluto.plugin.PlutoPlugin"
    }
  }
}

pluginBundle {
  website = WEBSITE
  vcsUrl = VCS_URL
  description = DESCRIPTION

  (plugins) {
    NAME {
      displayName = NAME
      tags = listOf("pluto", "toolbox", "kotlin")
    }
  }
}

configure<PublishExtension> {
  bintrayUser = project.properties["bintray.user"] as? String ?: System.getProperty("BINTRAY_USER")
  bintrayKey = project.properties["bintray.apikey"] as? String ?: System.getProperty("BINTRAY_API_KEY")

  userOrg = "otormaigh"
  groupId = GROUP_ID
  artifactId = "pluto-plugin"
  publishVersion = VERSION
  desc = DESCRIPTION
  website = WEBSITE
  dryRun = false
}