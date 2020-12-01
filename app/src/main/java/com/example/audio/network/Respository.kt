package com.example.audio.network

import androidx.lifecycle.liveData
import com.example.audio.R
import com.example.audio.adapter.HomeListAdapter
import com.example.audio.base.AudioApplication
import com.example.audio.model.HomeListItem
import com.example.audio.model.Song
import com.example.audio.ui.fragment.HomeFragment
import com.example.audio.util.FragmentUtil
import kotlinx.coroutines.Dispatchers

object Respository {
    fun getsongList(query:String) = liveData(Dispatchers.IO) {
        val result = try {
            val songRespose=AudioNetwork.getSongList("20")
            if(songRespose.code==200){
                val songlist=songRespose.result
                Result.success(songlist)
            }else{
                Result.failure<List<Song>>(RuntimeException("response state is ${songRespose.code}"))
            }
        }catch (e:Exception){
            Result.failure <List<Song>>(e)
        }
        emit(result as Result<List<Song>>)
    }

}