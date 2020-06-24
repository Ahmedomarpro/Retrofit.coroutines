package com.chase.kotlincoroutines.network

 import com.chase.kotlincoroutines.model.User
 import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {
    @GET("users")
    suspend fun getPosts(): Response<List<User>>
}