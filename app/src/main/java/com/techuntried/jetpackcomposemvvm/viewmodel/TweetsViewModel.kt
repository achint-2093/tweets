package com.techuntried.jetpackcomposemvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techuntried.jetpackcomposemvvm.models.TweetItem
import com.techuntried.jetpackcomposemvvm.repository.TweetsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TweetsViewModel @Inject constructor(private val repository: TweetsRepository) :
    ViewModel() {


    val tweets: StateFlow<List<TweetItem>>
        get() = repository.tweets

    init {
        getTweets("Motivation")
    }

    fun getTweets(category: String) {
        viewModelScope.launch {
            repository.getTweets(category)
        }
    }

}