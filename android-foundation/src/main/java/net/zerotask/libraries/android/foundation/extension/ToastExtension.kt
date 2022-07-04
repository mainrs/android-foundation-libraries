package net.zerotask.libraries.android.foundation.extension

import android.content.Context
import android.widget.Toast

fun Context.toast(message: String) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT)

fun Context.toastLong(message: String) =
    Toast.makeText(this, message, Toast.LENGTH_LONG)
