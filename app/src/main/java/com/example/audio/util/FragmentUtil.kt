package com.example.audio.util

import androidx.recyclerview.widget.RecyclerView
import com.example.audio.R
import com.example.audio.base.BaseFragment
import com.example.audio.ui.fragment.HomeFragment
import com.example.audio.ui.fragment.MvFragment
import com.example.audio.ui.fragment.VbangFragment
import com.example.audio.ui.fragment.YuedanFragment
object FragmentUtil {
    val homefragment by lazy { HomeFragment() }
    val mvfragment by lazy { MvFragment() }
    val vbangFragment by lazy { VbangFragment() }
    val yuedanFragment by lazy { YuedanFragment() }
    fun getFragment(fragmentId:Int):BaseFragment{
        when(fragmentId){
            R.id.tab_shouye -> return homefragment
            R.id.tab_mv -> return mvfragment
            R.id.tab_vbang -> return vbangFragment
            R.id.tab_yuedan -> return  yuedanFragment
        }
    return homefragment
    }

}