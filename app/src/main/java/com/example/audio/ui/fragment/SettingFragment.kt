package com.example.audio.ui.fragment

import android.os.Bundle
import android.preference.Preference
import android.preference.PreferenceFragment
import android.preference.PreferenceScreen
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.audio.R
import com.example.audio.ui.activity.MainActivity
import com.example.audio.ui.activity.Setting

class SettingFragment : PreferenceFragment(){

    override fun onCreateView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        addPreferencesFromResource(R.xml.setting)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onPreferenceTreeClick(
        preferenceScreen: PreferenceScreen?,
        preference: Preference?
    ): Boolean {
        val key =preference?.key
        when(key){
            "about" ->{
                Toast.makeText(activity,"关于",Toast.LENGTH_SHORT).show()
            }
        }
        return super.onPreferenceTreeClick(preferenceScreen, preference)
    }
}