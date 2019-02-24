package ie.otormaigh.pluto.plugin.toolbox

object BuildConst {
  const val NAME = "pluto"
  const val GROUP_ID = "ie.otormaigh.pluto"
  val VERSION: String
    get() = "0.1-${System.currentTimeMillis()}"
  const val DESCRIPTION = "A Gradle plugin toolbox containing helper functions and tasks."
  const val WEBSITE = "https://otormaigh.ie"
  const val VCS_URL = "https://github.com/otormaigh/pluto-android"
}