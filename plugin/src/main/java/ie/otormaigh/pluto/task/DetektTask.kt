package ie.otormaigh.pluto.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.PathSensitive
import org.gradle.api.tasks.PathSensitivity
import org.gradle.api.tasks.TaskAction
import java.io.File

open class DetektTask : DefaultTask() {
  @InputFile
  @PathSensitive(PathSensitivity.RELATIVE)
  lateinit var configFile: File

  init {
    group = "verification"
    description = "Detekt checker."
  }

  @TaskAction
  fun run() {
    val configuration = project.configurations.getByName("detekt")
  }

  private fun configure() {
    project.javaexec {
      main = "io.gitlab.arturbosch.detekt.cli.Main"
      classpath = project.configurations.getByName("detekt")
      args(
        "--input", project.file("."),
        "--config", configFile,
        "--filters", ".*build/.*",
        "--report", "html:${project.rootDir}/app/build/reports/detekt/detekt.html"
      )
    }
  }
}

//open class DetektTask : JavaExec() {
//  init {
//    project.configurations.create("detekt")
//    main = "io.gitlab.arturbosch.detekt.cli.Main"
//    classpath = project.configurations.getByName("detekt")
//
//    val input = "${project.rootDir}/app"
//    val config = "${project.rootDir}/buildSrc/detekt.yml"
//    val filters = ".*Test.*,.*AndroidTest.*,.*/resources/.*,.*/tmp/.*"
//    val report = "html:${project.rootDir}/app/build/reports/detekt/detekt.html"
//    val params = listOf("-i", input, "-c", config, "-f", filters, "-r", report)
//    args(params)
//
//    project.dependencies.add("detekt", "io.gitlab.arturbosch.detekt:detekt-cli:1.0.0-RC14")
//  }
//}