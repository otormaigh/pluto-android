package ie.otormaigh.pluto.plugin

import ie.otormaigh.pluto.plugin.task.DeployConfiguration
import org.gradle.api.Action

open class PlutoLocalExtension {
  val deployConfig = DeployConfiguration()

  fun deploy(action: Action<in DeployConfiguration>) {
    action.execute(deployConfig)
  }

  companion object {
    const val NAME = "plutoLocal"
  }
}