package com.example.audio.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.ViewPropertyAnimatorListener
import com.example.audio.R
import com.example.audio.base.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SpiashActivity :BaseActivity(),ViewPropertyAnimatorListener{
    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun initData() {
        //开始欢迎界面动画缩小
        ViewCompat.animate(splashimage).scaleX(1.0f).scaleY(1.0f).setListener(this).setDuration(2000)
    }

    override fun onAnimationEnd(view: View?) {
       //动画结束进入主界面
        val intent=Intent(this,MainActivity::class.java)
        startActivity(intent)
        //避免退出主界面后，进入欢迎界面
        finish()
    }

    override fun onAnimationCancel(view: View?) {

    }

    override fun onAnimationStart(view: View?) {

    }
}