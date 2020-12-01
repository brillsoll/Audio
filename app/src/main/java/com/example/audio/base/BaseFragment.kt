package com.example.audio.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }
    //初始化fragment
   protected fun init() {

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return initView(container,inflater)
    }
    //获取布局id
   abstract fun initView(container: ViewGroup?, inflater: LayoutInflater): View?

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initListener()
        initData()
    }
    //初始化listen
    open protected fun initListener() {

    }
    //初始化数据
    open protected fun initData(){

    }
}