package ie.otormaigh.pluto.plugin.task

import com.novoda.gradle.release.PublishExtension
import ie.otormaigh.pluto.plugin.toolbox.BuildConst
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class DeployConfiguration {
  var enable = false
  lateinit var artifactId: String

  internal fun maven(project: Project) {
    project.configure<PublishExtension> {
      bintrayUser = project.properties["bintray.user"] as String
      bintrayKey = project.properties["bintray.apikey"] as String

      userOrg = "otormaigh"
      groupId = BuildConst.GROUP_ID
//      artifactId = this@DeployConfiguration.artifactId
      publishVersion = BuildConst.VERSION
      desc = BuildConst.DESCRIPTION
      website = BuildConst.WEBSITE
      dryRun = false
    }
  }
}