package com.example.postsapp.data.api

import com.example.postsapp.data.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface PostsApiService {
    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>
}