package ie.otormaigh.pluto.task

import ie.otormaigh.pluto.toolbox.extension.runCommand
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import java.io.File

open class GenerateChangelogTask : DefaultTask() {
  init {
    group = "Releasing"
    description = "Generate a changelog based on the range of commits that triggered a build on CircleCI."
  }

  @TaskAction
  fun run() {
    var commitRange = System.getenv("CIRCLE_COMPARE_URL").split("/").last()
    if (commitRange.isEmpty()) System.getenv("CIRCLE_SHA1")
    if (!commitRange.contains("...")) commitRange = "HEAD^..$commitRange"
    logger.info("commitRange -> $commitRange")

    File("app/src/main/play/release-notes/en-GB/internal.txt").apply {
      createNewFile()
      writeText("""git log '--pretty=- %s' $commitRange""".runCommand() ?: "")
    }
  }
}