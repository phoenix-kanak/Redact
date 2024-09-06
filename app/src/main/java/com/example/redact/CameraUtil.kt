package com.example.redact

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.provider.MediaStore

class CameraUtil(private val context: Context) {
    private val REQUEST_IMAGE_CAPTURE  = 100
    fun takePhoto(activity: Activity) {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (intent.resolveActivity(activity.packageManager) != null) {
            activity.startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)
        }
    }

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?, callback: (Bitmap?) -> Unit) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as? Bitmap
            callback(imageBitmap)
        }
    }
}