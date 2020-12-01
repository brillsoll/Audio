package com.example.audio.ui.fragment

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.audio.R
import com.example.audio.adapter.HomeListAdapter
import com.example.audio.base.AudioApplication
import com.example.audio.base.BaseFragment
import com.example.audio.model.HomeListItem
import com.example.audio.network.Respository
import com.example.audio.ui.song.SongViewModel
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment :BaseFragment(){
    lateinit var  list: ArrayList<HomeListItem>

    //
    val SongVieModel by lazy { ViewModelProviders.of(this).get(SongViewModel::class.java) }
    override fun initView(container: ViewGroup?, inflater: LayoutInflater): View? {
        val view=inflater.inflate(R.layout.home_fragment,container,false)
        return view
    }

    override fun initData() {
        super.initData()
        initList()
        val layoutManager=LinearLayoutManager(activity)
        val adapter= activity?.let { HomeListAdapter(it,list) }
        homelist.layoutManager=layoutManager
        homelist.adapter=adapter
        swiperefresh.setColorSchemeResources(R.color.colorPrimary)
        swiperefresh.setOnRefreshListener {
            refresh()
        }

    }
    //上拉加载更多
    fun addmore(){

    }
    //下拉刷新
fun refresh(){
        SongVieModel.getSongList("25")
        swiperefresh.isRefreshing=true
    }
    //填满菜单
    fun initList() {
        //list= ArrayList<HomeListItem>()
        //val item=HomeListItem(R.drawable.homelistimagedemo,R.drawable.hot,"最暖下午茶音乐")
        // list.add(item)
            list = ArrayList<HomeListItem>()
            SongVieModel.songLiveData.observe(this, Observer { result ->

                val songList = result.getOrNull()

                if (songList != null) {
                    for (item in songList) {
                        val i = HomeListItem(
                            R.drawable.homelistimagedemo,
                            R.drawable.hot,
                            item.name,
                            item.picUrl
                        )
                        Log.d("HomeFragment", item.name)
                        list.add(i)

                    }

                } else {
                    Toast.makeText(activity, "网络异常", Toast.LENGTH_SHORT).show()
                    result.exceptionOrNull()?.printStackTrace()
                    val item = HomeListItem(R.drawable.homelistimagedemo, R.drawable.hot, "最暖下午茶音乐")
                    list.add(item)
                }
                swiperefresh.isRefreshing=false
            })
            SongVieModel.getSongList("20")

        }

        fun freshlist(list: ArrayList<HomeListItem>) {
            val adapter = activity?.let { HomeListAdapter(it, list) }
            homelist.adapter = adapter

        }

}