package com.davidhernandezn.climapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(2000)//no recomendado
        setTheme(R.style.Theme_ClimApp)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}