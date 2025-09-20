package com.example.postsapp.data.repository

import com.example.postsapp.data.Constants.MAX_POST_ID
import com.example.postsapp.data.api.PostsApiService
import com.example.postsapp.data.model.Post
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PostsRepositoryImpl(
    private val apiService: PostsApiService
) : PostsRepository {

    override fun getPosts(): Flow<Result<List<Post>>> = flow {
        try {
            val response = apiService.getPosts()

            if (response.isSuccessful) {
                val allPosts = response.body() ?: emptyList()

                // Business logic: Filter posts with id < MAX_POST_ID
                val filteredPosts = allPosts.filter { it.id < MAX_POST_ID }

                emit(Result.success(filteredPosts))
            } else {
                emit(Result.failure(Exception("API Error: ${response.code()}")))
            }
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
}