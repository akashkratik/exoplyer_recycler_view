package com.example.videoapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.models.DataResponse
import com.example.api.models.Msg
import com.example.videoapp.data.ResponseRepo
import kotlinx.coroutines.launch
import okhttp3.Response

class VideosViewModel: ViewModel() {
    private val _response = MutableLiveData<List<Msg>>()

    val response: LiveData<List<Msg>> = _response

    fun getVideos() = viewModelScope.launch{
        ResponseRepo.getVideosLink().body()?.let{
            _response.postValue(it.msg)
            Log.d("Videos", "msg fetched ${it.code}")
        }
    }

}