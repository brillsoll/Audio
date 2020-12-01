package com.example.audio.ui.song

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.audio.model.Song
import com.example.audio.network.Respository

class SongViewModel :ViewModel(){
private val searchLiveData = MutableLiveData<String>()
val songList =ArrayList<Song>()
val songLiveData = Transformations.switchMap(searchLiveData){ size->
    Respository.getsongList(size)


}
fun getSongList(size : String){
    searchLiveData.value=size
}

}