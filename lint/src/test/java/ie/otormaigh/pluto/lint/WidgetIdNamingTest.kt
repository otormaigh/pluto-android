package ie.otormaigh.pluto.lint

import com.android.tools.lint.checks.infrastructure.TestFiles
import com.android.tools.lint.checks.infrastructure.TestLintTask
import org.junit.Test

class WidgetIdNamingTest {
  @Test
  fun testSnakeCase() {
    TestLintTask.lint()
      .files(
        TestFiles.xml(
          "res/layout/activity_main.xml",
          """
            <TextView xmlns:android="http://schemas.android.com/apk/res/android" android:id="@+id/tv_text_view"/>
            """).indented())
      .issues(WidgetIdNaming.ISSUE)
      .run()
      .expect("""
            |res/layout/activity_main.xml:1: Warning: Id's should be camelCase: tv_text_view [WidgetIdNaming]
            |<TextView xmlns:android="http://schemas.android.com/apk/res/android" android:id="@+id/tv_text_view"/>
            |                                                                                 ~~~~~~~~~~~~~~~~~
            |0 errors, 1 warnings""".trimMargin())
      .expectFixDiffs("""
            |Fix for res/layout/activity_main.xml line 1: Replace with tvTextView:
            |@@ -1 +1
            |- <TextView xmlns:android="http://schemas.android.com/apk/res/android" android:id="@+id/tv_text_view"/>
            |@@ -2 +1
            |+ <TextView xmlns:android="http://schemas.android.com/apk/res/android" android:id="@+id/tvTextView"/>
            |""".trimMargin())
  }
}