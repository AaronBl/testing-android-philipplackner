package com.fintecimal.testandroidphilipplackner

import android.content.Context

class ResourceComparer {
    fun isEquals(context: Context, resId: Int, string: String): Boolean {
        return context.getString(resId) == string
    }
}