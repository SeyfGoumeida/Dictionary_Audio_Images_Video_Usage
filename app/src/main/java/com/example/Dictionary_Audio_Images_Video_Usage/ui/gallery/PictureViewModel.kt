package com.example.Dictionary_Audio_Images_Video_Usage.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PictureViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Picture Fragment"
    }
    val text: LiveData<String> = _text
}