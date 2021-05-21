package com.example.videoapp.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.api.models.Msg
import com.example.videoapp.MainActivity.Companion.player
import com.example.videoapp.R
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.PlayerView
import kotlin.collections.ArrayList

class VideosAdapter2(private val context: Context)
    :RecyclerView.Adapter<VideosAdapter2.ViewHolder>(){
    private var list: List<Msg> = ArrayList()
    private var  trackSelector =  DefaultTrackSelector(context)
    fun getList(list: List<Msg>){
        this.list = list
        notifyDataSetChanged()
    }

    class ViewHolder(v: View): RecyclerView.ViewHolder(v) {
        val playerView = v.findViewById<PlayerView>(R.id.video_view)
        var createrName = v.findViewById<TextView>(R.id.creater_name)
        var imageThumbnail = v.findViewById<ImageView>(R.id.image_thumbnail)

    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
//        player = SimpleExoPlayer.Builder(context).build()
        recyclerView.setItemViewCacheSize(5)
        trackSelector.setParameters(trackSelector.buildUponParameters().setMaxVideoSizeSd())
        player = SimpleExoPlayer.Builder(context).setTrackSelector(trackSelector).build()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewHolder = ViewHolder(LayoutInflater.from(context)
            .inflate(R.layout.list_item_recycler_view,
            parent,
            false))
//        DefaultLoadControl.Builder()
//            .setBufferDurationsMs(
//                2000,
//                10000,
//                2000,
//                2000
//            ).build()
        Toast.makeText(context, "created", Toast.LENGTH_SHORT).show()
        return viewHolder
    }

//    override fun onViewRecycled(holder: ViewHolder) {
//        val position = holder.adapterPosition
//        Toast.makeText(context, "Recycled", Toast.LENGTH_LONG).show()
//        player?.setPlayWhenReady(false)
//        onBindViewHolder(holder, position+1)
//        super.onViewRecycled(holder)
//    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setIsRecyclable(false)
        Toast.makeText(context, "Binded", Toast.LENGTH_SHORT).show()
        holder.playerView.setPlayer(player)
        Glide.with(context).load(list[position].thum).into(holder.imageThumbnail)
        holder.createrName.text = list[position].userInfo.username
//        playerView.setPlayer(player)
        var mediaItem = MediaItem.fromUri(list[position].video)
        player?.setMediaItem(mediaItem)
    }

    override fun onViewAttachedToWindow(holder: ViewHolder) {
        super.onViewAttachedToWindow(holder)
        player?.setPlayWhenReady(true)
        player?.seekTo(0,0)
        player?.prepare()
        holder.imageThumbnail.visibility = View.GONE
        player?.play()

    }

    override fun onViewDetachedFromWindow(holder: ViewHolder) {
        super.onViewDetachedFromWindow(holder)
//        player?.setPlayWhenReady(false)
        player?.pause()
        holder.imageThumbnail.visibility = View.VISIBLE
    }

    override fun getItemCount(): Int {
        return list.size
    }

}