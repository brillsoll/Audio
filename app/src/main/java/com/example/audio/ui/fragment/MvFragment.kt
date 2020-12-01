package com.example.audio.ui.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.audio.base.BaseFragment

class MvFragment :BaseFragment(){
    override fun initView(container: ViewGroup?, inflater: LayoutInflater): View? {
        val tv= TextView(context)
        tv.text="MV"
        return tv
    }
}