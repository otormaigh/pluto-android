package ie.otormaigh.pluto.plugin.toolbox.extension

import ie.otormaigh.pluto.plugin.PlutoLocalExtension
import org.gradle.api.Action
import org.gradle.api.Project

fun Project.plutoLocal(configure: Action<PlutoLocalExtension>) {
  project.extensions.configure(PlutoLocalExtension::class.java, configure)
}