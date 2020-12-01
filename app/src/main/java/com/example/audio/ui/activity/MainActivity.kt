package com.example.audio.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.audio.R
import com.example.audio.base.AudioApplication
import com.example.audio.base.BaseActivity
import com.example.audio.ui.fragment.HomeFragment
import com.example.audio.util.FragmentUtil
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_setting.view.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun initData() {
        super.initData()
        //加载设置按钮上的ToolBar按钮
        toolbar.inflateMenu(R.menu.menu)
        toolbar.title="快播影音"
    }
    override fun initListener() {
        super.initListener()
        //监听Toolbar上的设置按钮
        toolbar.setOnMenuItemClickListener{
            when(it?.itemId){
                R.id.setting -> {
                    //跳转到设置界面
                    val intent = Intent(this, Setting::class.java)
                    startActivity(intent)
                }
            }
            false
        }
        //设置bottombar上面按钮监听
        bottomBar.setOnTabSelectListener {
            val transaction =supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container,FragmentUtil.getFragment(it))
            transaction.commit()
        }
     

    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//       toolbar.inflateMenu(R.menu.menu)
//        return true
//    }
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when(item.itemId){
//            R.id.setting ->{
//                val intent = Intent(this,Setting::class.java)
//                startActivity(intent)
//            }
//        }
//        return true
//    }
}


