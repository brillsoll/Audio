package com.example.audio.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initListener()
        initData()
    }
    //初始化数据
  open  protected fun initData() {

    }

    //adater和listener有关
  open  protected fun initListener(){

    }

    //获取布局id
    abstract fun getLayoutId(): Int
}