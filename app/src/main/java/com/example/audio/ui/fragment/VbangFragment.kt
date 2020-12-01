package com.example.audio.ui.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.audio.base.BaseFragment

class VbangFragment :BaseFragment(){

    override fun initView(container: ViewGroup?, inflater: LayoutInflater): View? {
        val tv= TextView(context)
        tv.text="V榜"
        return tv
    }
}