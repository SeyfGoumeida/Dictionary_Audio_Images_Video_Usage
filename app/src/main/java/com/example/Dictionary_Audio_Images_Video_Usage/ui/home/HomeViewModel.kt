package com.example.Dictionary_Audio_Images_Video_Usage.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Tech Dictionary"
    }
    val text: LiveData<String> = _text


}