package ie.otormaigh.pluto.lint

import com.android.SdkConstants
import com.android.resources.ResourceFolderType
import com.android.tools.lint.detector.api.Category.Companion.CORRECTNESS
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.ResourceXmlDetector
import com.android.tools.lint.detector.api.Scope
import com.android.tools.lint.detector.api.Severity.WARNING
import com.android.tools.lint.detector.api.XmlContext
import com.android.tools.lint.detector.api.stripIdPrefix
import ie.otormaigh.pluto.lint.extension.isIdCamelCase
import ie.otormaigh.pluto.lint.extension.toIdCamelCase
import org.w3c.dom.Attr
import java.util.*

class WidgetIdNaming : ResourceXmlDetector() {
  override fun appliesTo(folderType: ResourceFolderType) = EnumSet.of(ResourceFolderType.LAYOUT).contains(folderType)
  override fun getApplicableAttributes() = listOf(SdkConstants.ATTR_ID)

  override fun visitAttribute(context: XmlContext, attribute: Attr) {
    val id = stripIdPrefix(attribute.value)

    if (!id.isIdCamelCase()) {
      val fix = fix()
        .replace()
        .text(id)
        .with(id.toIdCamelCase())
        .autoFix()
        .build()

      context.report(
        ISSUE,
        context.getValueLocation(attribute),
        "Id's should be camelCase: $id",
        fix)
    }
  }

  companion object {
    val ISSUE = Issue.create(
      "WidgetIdNaming",
      "Widget ID format should be camelCase.",
      "When setting an ID to a widget, always use camelCase.",
      CORRECTNESS,
      PRIORITY,
      WARNING,
      Implementation(WidgetIdNaming::class.java, Scope.RESOURCE_FILE_SCOPE))
  }
}