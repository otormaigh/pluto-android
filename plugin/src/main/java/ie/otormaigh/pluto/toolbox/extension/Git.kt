package ie.otormaigh.pluto.toolbox.extension

object Git {
  val shortHash = "git rev-parse --short HEAD".runCommand()?.trim() ?: ""
}