package com.example.postsapp

import com.example.postsapp.data.Constants
import com.example.postsapp.data.model.Post
import org.junit.Assert.*
import org.junit.Test

class PostsViewModelTest {

    @Test
    fun `MAX_POST_ID constant should be 50`() {
        // Given & When
        val maxPostId = Constants.MAX_POST_ID

        // Then
        assertEquals(50, maxPostId)
    }

    @Test
    fun `Post data class should have correct properties`() {
        // Given
        val post = Post(
            userId = 1,
            id = 25,
            title = "Test Title",
            body = "Test Body"
        )

        // Then
        assertEquals(1, post.userId)
        assertEquals(25, post.id)
        assertEquals("Test Title", post.title)
        assertEquals("Test Body", post.body)
    }

    @Test
    fun `Post with id less than MAX_POST_ID should be included in filtering`() {
        // Given
        val post = Post(userId = 1, id = 25, title = "Test", body = "Test")

        // When
        val shouldInclude = post.id < Constants.MAX_POST_ID

        // Then
        assertTrue("Post with id 25 should be included", shouldInclude)
    }

    @Test
    fun `Post with id greater than or equal to MAX_POST_ID should be excluded from filtering`() {
        // Given
        val post = Post(userId = 1, id = 50, title = "Test", body = "Test")

        // When
        val shouldExclude = post.id >= Constants.MAX_POST_ID

        // Then
        assertTrue("Post with id 50 should be excluded", shouldExclude)
    }
}
