package ie.otormaigh.pluto.plugin.task

import ie.otormaigh.pluto.plugin.PlutoLocalExtension
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

open class DeployTask : DefaultTask() {
  @Input
  lateinit var plutoLocalExtension: PlutoLocalExtension

  init {
    group = "Releasing"
    description = "Placeholder description"
  }

  @TaskAction
  fun run() {
    plutoLocalExtension.deployConfig.maven(project)
  }

  companion object {
    const val NAME = "deploy"
  }
}