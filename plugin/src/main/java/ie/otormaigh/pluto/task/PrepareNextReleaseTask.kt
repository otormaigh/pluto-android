package ie.otormaigh.pluto.task

import ie.otormaigh.pluto.toolbox.extension.Git
import ie.otormaigh.pluto.toolbox.extension.runCommand
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

open class PrepareNextReleaseTask : DefaultTask() {
  init {
    group = "Releasing"
    description = "Prepares the project for the next release version"
  }

  @TaskAction
  fun run() {
    val newVersion = "0.1"
      .replaceAfter("-", "")
      .removeSuffix("-")

    // 7. Create a new release branch `git checkout -b release-{versionName}`
    """git checkout -b release-$newVersion""".runCommand()

    // 8. Update previous `CHANGELOG.md` entry to append title with the build commit of that release
    """sed -i '' -e '1 s/$/ - ${Git.shortHash}/' ${project.rootDir}/CHANGELOG.md""".runCommand()

    // 9. Commit changes `git commit -am 'bump version to {versionName}'
    """git commit -am 'bump version to $newVersion'""".runCommand()
  }
}