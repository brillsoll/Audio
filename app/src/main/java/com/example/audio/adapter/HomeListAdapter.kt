package com.example.audio.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.audio.R
import com.example.audio.model.HomeListItem
import com.example.audio.model.Song
import retrofit2.http.Url

class HomeListAdapter(val context: Context, val homeList: List<HomeListItem>) : RecyclerView.Adapter<HomeListAdapter.ViewHolder>() {
    inner class ViewHolder(view : View):RecyclerView.ViewHolder(view){
        val bg:ImageView=view.findViewById(R.id.homelistbg)
        val image:ImageView=view.findViewById(R.id.homelistimg)
        val text:TextView=view.findViewById(R.id.homelisttext)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.homelist_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int =homeList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val homeitem=homeList[position]
        //holder.bg.setImageResource(homeitem.bg)
       // holder.image.setImageResource(homeitem.image)
        if (homeitem.imageUri.equals("")){
            Glide.with(context).load(homeitem.bg).into(holder.bg)
        }else{
            Glide.with(context).load(homeitem.imageUri).into(holder.bg)
        }

        Glide.with(context).load(homeitem.image).into(holder.image)

        holder.text.text=homeitem.text
    }
}