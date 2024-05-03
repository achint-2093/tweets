package com.techuntried.jetpackcomposemvvm.repository

import com.techuntried.jetpackcomposemvvm.api.TweetsApi
import com.techuntried.jetpackcomposemvvm.models.TweetItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetsRepository @Inject constructor(private val tweetsApi: TweetsApi) {

    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>>
        get() = _categories

    private val _tweets = MutableStateFlow<List<TweetItem>>(emptyList())
        val tweets: StateFlow<List<TweetItem>> =
            _tweets

    suspend fun getCategories() {
        val response = tweetsApi.getTweetsCategory()
        if (response.isSuccessful && response.body() != null) {
            _categories.emit(response.body()!!)
        }
    }

    suspend fun getTweets(category:String) {
        val response = tweetsApi.getTweets("tweets[?(@.category==\"$category\")]")
        if (response.isSuccessful && response.body() != null) {
            _tweets.emit(response.body()!!)
        }
    }

}

