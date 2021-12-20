package com.davidhernandezn.climapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class Ciudades : AppCompatActivity() {
    val TAG = "com.davidhernandezn.climapp.ciudades.CIUDAD"

    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(2000)//no recomendado
        setTheme(R.style.Theme_ClimApp)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudades)

        val btnTlaxcala = findViewById<Button>(R.id.btlaxcala)
        val btnPuebla = findViewById<Button>(R.id.bpuebla)

        btnTlaxcala.setOnClickListener (View.OnClickListener {
            //Toast.makeText(this, "Tlaxcala City", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(TAG, "3815415")
            startActivity(intent)
        })

        btnPuebla.setOnClickListener (View.OnClickListener {
            //Toast.makeText(this, "Cd Puebla", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(TAG, "3521081")
            startActivity(intent)
        })
    }
}