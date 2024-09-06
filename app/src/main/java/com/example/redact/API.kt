package com.example.redact

import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface API {
    @Multipart
    @POST("/process-file")
    suspend fun uploadImage(
        @Part image: MultipartBody.Part,
    ): Response<ResponseBody>
}