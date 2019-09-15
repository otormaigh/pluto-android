buildscript {
  repositories {
    google()
    jcenter()
  }

  dependencies {
    classpath("com.android.tools.build:gradle:3.5.0-alpha09")
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${ie.otormaigh.pluto.toolbox.Deps.Version.kotlin}")
  }
}
allprojects {
  repositories {
    google()
    jcenter()
  }
}

task<Delete>("clean") {
  delete = setOf(rootProject.buildDir)
}

tasks.withType(Wrapper::class.java) {
  gradleVersion = "5.3-rc-2"
  distributionType = Wrapper.DistributionType.ALL
}