package com.example.redact

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import okhttp3.MultipartBody
import java.io.File
import javax.inject.Inject

class ImageRepo @Inject constructor(private val api: API) {

//    suspend fun uploadImage(imageFile: File): Bitmap? {
//        val requestFile = imageFile.asRequestBody("image/jpeg".toMediaTypeOrNull())
//        val body = MultipartBody.Part.createFormData("image", imageFile.name, requestFile)
//
//        val response = apiService.uploadImage(body)
//
//        return if (response.isSuccessful) {
//            // Convert response to Bitmap
//            response.body()?.byteStream()?.let { BitmapFactory.decodeStream(it) }
//        } else {
//            null
//        }
//    }
}