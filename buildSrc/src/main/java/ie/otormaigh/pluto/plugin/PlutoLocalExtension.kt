package ie.otormaigh.pluto.plugin

import ie.otormaigh.pluto.plugin.task.DeployConfiguration
import org.gradle.api.Action
import org.gradle.api.Project

open class PlutoLocalExtension {
  lateinit var project: Project
  val deployConfig = DeployConfiguration()

  fun deploy(action: Action<in DeployConfiguration>) {
    action.execute(deployConfig)
  }
}