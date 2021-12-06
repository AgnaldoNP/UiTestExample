package com.example.myapplication.commom

import android.app.AlertDialog
import android.content.Context
import com.example.myapplication.R

fun Context.showError(message: String) {
    AlertDialog.Builder(this)
        .setMessage(message)
        .setPositiveButton(
            R.string.ok
        ) { dialog, _ -> dialog.dismiss() }
        .show()
}
