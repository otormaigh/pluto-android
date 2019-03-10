import ie.otormaigh.pluto.plugin.toolbox.BuildConst
import ie.otormaigh.pluto.plugin.toolbox.extension.plutoLocal

repositories {
  jcenter()
}

plugins {
  `kotlin-dsl`
  `java-gradle-plugin`
  id("com.gradle.plugin-publish") version "0.10.1"
}
//configure<PublishExtension> {
//  artifactId = "pluto-plugin"
//}
apply<ie.otormaigh.pluto.plugin.PlutoLocalPlugin>()
plutoLocal {
  deploy {
    enable = true
    artifactId = "pluto"
  }
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