import com.novoda.gradle.release.PublishExtension
import ie.otormaigh.pluto.plugin.toolbox.BuildConst

repositories {
  jcenter()
}

plugins {
  `kotlin-dsl`
  `java-gradle-plugin`
  id("com.gradle.plugin-publish") version "0.10.1"
}
apply<ie.otormaigh.pluto.plugin.PlutoLocalPlugin>()

configure<PublishExtension> {
  artifactId = "pluto-plugin"
}

group = BuildConst.GROUP_ID
version = BuildConst.VERSION

gradlePlugin {
  plugins {
    create(BuildConst.NAME) {
      id = BuildConst.GROUP_ID
      implementationClass = "ie.otormaigh.pluto.plugin.PlutoPlugin"
    }
  }
}

pluginBundle {
  website = BuildConst.WEBSITE
  vcsUrl = BuildConst.VCS_URL
  description = BuildConst.DESCRIPTION

  (plugins) {
    BuildConst.NAME {
      displayName = BuildConst.NAME
      tags = listOf("pluto", "toolbox", "kotlin")
    }
  }
}