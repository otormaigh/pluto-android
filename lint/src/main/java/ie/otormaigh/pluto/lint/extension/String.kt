package ie.otormaigh.pluto.lint.extension

import java.util.*
import java.util.regex.Pattern

internal fun String.isIdCamelCase() =
  !Character.isUpperCase(first()) && !contains("_")

internal fun String.toIdCamelCase(): String {
  val matcher = Pattern.compile("_(.)").matcher(this)
  val sb = StringBuffer()

  while (matcher.find()) {
    matcher.appendReplacement(sb, matcher.group(1).toUpperCase(Locale.ENGLISH))
  }
  matcher.appendTail(sb)

  sb.setCharAt(0, Character.toLowerCase(sb[0]))
  return sb.toString()
}