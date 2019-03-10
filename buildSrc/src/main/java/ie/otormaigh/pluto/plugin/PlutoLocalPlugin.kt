package ie.otormaigh.pluto.plugin

import com.novoda.gradle.release.ReleasePlugin
import ie.otormaigh.pluto.plugin.task.DeployTask
import org.gradle.api.Plugin
import org.gradle.api.Project

class PlutoLocalPlugin : Plugin<Project> {
  override fun apply(target: Project) {
    val plutoLocalExtension = target.extensions.create(PlutoLocalExtension.NAME, PlutoLocalExtension::class.java)

    target.afterEvaluate {
      if (plutoLocalExtension.deployConfig.enable) {
        target.tasks.register(DeployTask.NAME, DeployTask::class.java) {
          this.plutoLocalExtension = plutoLocalExtension
//          dependsOn("bintrayUpload")
        }

//        target.plugins.apply(ReleasePlugin::class.java)
//        plutoLocalExtension.deployConfig.maven(target)
      }
    }
  }
}