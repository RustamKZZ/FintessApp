package com.hrv.fintessapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hrv.fintessapp.fragments.DaysFragment
import com.hrv.fintessapp.utils.FragmentManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FragmentManager.setFragment(DaysFragment.newInstance(), this)
    }
}