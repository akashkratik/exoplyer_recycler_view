package com.example.videoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.videoapp.data.VideosAdapter2
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.util.Util


class MainActivity : AppCompatActivity() {

    companion object{
        var player: SimpleExoPlayer? = null
        var playWhenReady = true
        var currentWindow = 0
        var playbackPosition: Long = 0
    }

    private lateinit var videosViewModel: VideosViewModel
    private lateinit var adapter: VideosAdapter2



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.videos_activity_main)

        val videosRecyclerView = findViewById<RecyclerView>(R.id.videos_recycler_view)
        videosViewModel = ViewModelProvider(this).get(VideosViewModel::class.java)
        videosViewModel.getVideos()
        videosViewModel.response.observe({lifecycle}){
            adapter.getList(it)
        }

        adapter = VideosAdapter2(this)
        videosRecyclerView.adapter = adapter
    }


    override fun onStop() {
        super.onStop()
        if (Util.SDK_INT >= 24) {
            releasePlayer()
        }
    }
    private fun releasePlayer() {
        if (player != null) {
            playWhenReady = player!!.playWhenReady
            playbackPosition = player!!.currentPosition
            currentWindow = player!!.currentWindowIndex
            player!!.release()
            player = null
        }
    }

}