package ie.otormaigh.pluto.lint.toolbox.extension

import ie.otormaigh.pluto.lint.extension.isIdCamelCase
import ie.otormaigh.pluto.lint.extension.toIdCamelCase
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class StringTest {
  @Test
  fun testIsIdCamelCase() {
    assertFalse("tv_text_view".isIdCamelCase())
    assertFalse("TvTextView".isIdCamelCase())

    assertTrue("tvTextView".isIdCamelCase())
  }

  @Test
  fun testToIdCamelCase() {
    assertEquals("tv_text_view".toIdCamelCase(), "tvTextView")
    assertEquals("TvTextView".toIdCamelCase(), "tvTextView")
  }
}