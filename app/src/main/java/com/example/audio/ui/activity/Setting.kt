package com.example.audio.ui.activity

import android.os.Bundle
import android.widget.Toast
import com.example.audio.R
import com.example.audio.base.BaseActivity
import kotlinx.android.synthetic.main.toolbar.*

class Setting : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun initData() {
        super.initData()
        toolbar.title="设置"
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_setting
    }
}
