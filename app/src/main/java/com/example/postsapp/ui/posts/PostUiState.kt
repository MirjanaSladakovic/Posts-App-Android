package com.example.postsapp.ui.posts

import com.example.postsapp.data.model.Post

data class PostsUiState(
    val posts: List<Post> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)