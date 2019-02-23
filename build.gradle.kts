buildscript {
  repositories {
    google()
    jcenter()
  }

  dependencies {
    classpath("com.android.tools.build:gradle:3.5.0-alpha05")
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.21")
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
  gradleVersion = "5.2.1"
  distributionType = Wrapper.DistributionType.ALL
}