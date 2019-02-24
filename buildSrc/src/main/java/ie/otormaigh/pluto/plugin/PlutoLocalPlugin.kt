package ie.otormaigh.pluto.plugin

import com.novoda.gradle.release.ReleasePlugin
import ie.otormaigh.pluto.plugin.task.DeployTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.Delete
import org.gradle.api.tasks.wrapper.Wrapper

class PlutoLocalPlugin : Plugin<Project> {
  override fun apply(target: Project) {
    val plutoLocalExtension = target.extensions.create("plutoLocal", PlutoLocalExtension::class.java).apply {
      project = target
    }

    target.tasks.register(DeployTask.NAME, DeployTask::class.java) {
      this.plutoLocalExtension = plutoLocalExtension
      dependsOn("bintrayUpload")
    }

    target.plugins.apply(ReleasePlugin::class.java)
    plutoLocalExtension.deployConfig.maven(target)

    target.tasks.named("clean", Delete::class.java) {
      delete = setOf(target.rootProject.buildDir)
    }

    target.tasks.withType(Wrapper::class.java) {
      gradleVersion = "5.2.1"
      distributionType = Wrapper.DistributionType.ALL
    }
  }
}