package ie.otormaigh.pluto.toolbox.extension

import android.content.res.Resources

val Float.toPx: Float
  get() = this * Resources.getSystem().displayMetrics.density