package com.techuntried.jetpackcomposemvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techuntried.jetpackcomposemvvm.repository.TweetsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val repository: TweetsRepository) :
    ViewModel() {


    val categories: StateFlow<List<String>>
        get() =
            repository.categories

    init {
        viewModelScope.launch {
            repository.getCategories()
        }
    }

}