package ie.otormaigh.pluto.plugin

import ie.otormaigh.pluto.task.GenerateChangelogTask
import ie.otormaigh.pluto.task.PrepareNextReleaseTask
import org.gradle.api.Plugin
import org.gradle.api.Project

class PlutoPlugin : Plugin<Project> {
  override fun apply(target: Project) {
    target.tasks.register("generateChangelog", GenerateChangelogTask::class.java)
    target.tasks.register("prepareNextRelease", PrepareNextReleaseTask::class.java)
  }
}