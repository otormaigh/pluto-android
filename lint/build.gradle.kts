plugins {
  id("kotlin")
}

java {
  sourceCompatibility = JavaVersion.VERSION_1_7
  targetCompatibility = JavaVersion.VERSION_1_7
}

dependencies {
  compileOnly("com.android.tools.lint:lint-api:26.5.0-alpha06")
  compileOnly("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.21")
  testImplementation("com.android.tools.lint:lint:26.5.0-alpha06")
  testImplementation("com.android.tools.lint:lint-tests:26.5.0-alpha06")
}

val jar by tasks.getting(Jar::class) {
  manifest {
    attributes["Lint-Registry-v2"] = "ie.otormaigh.pluto.lint.PlutoIssueRegistry"
  }
}