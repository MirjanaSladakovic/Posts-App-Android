package com.example.postsapp.data.repository

import com.example.postsapp.data.model.Post
import kotlinx.coroutines.flow.Flow

interface PostsRepository {
    fun getPosts(): Flow<Result<List<Post>>>
}