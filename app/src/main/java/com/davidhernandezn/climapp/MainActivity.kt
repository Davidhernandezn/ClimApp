package com.davidhernandezn.climapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var tvCiudad:TextView? = null
    var tvGrados:TextView? = null
    var tvEstatus:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvCiudad = findViewById(R.id.tvCiudad)
        tvGrados = findViewById(R.id.tvGrados)
        tvEstatus= findViewById(R.id.tvEstatus)

        val ciudad = intent.getStringExtra("com.davidhernandezn.climapp.ciudades.CIUDAD")
      //  Toast.makeText(this, ciudad, Toast.LENGTH_SHORT).show()

        val ciudadtlx = Ciudad("Cd Tlaxcala", 15, "lluvioso")
        val ciudadpue = Ciudad("Cd Puebla", 23, "Nevando")

        if(ciudad == "cd-tlaxcala"){
            tvCiudad?.text = ciudadtlx.nombre
            tvGrados?.text = ciudadtlx.grados.toString()+ "°"
            tvEstatus?.text = ciudadtlx.estatus

        }else if (ciudad == "cd-puebla"){
            tvCiudad?.text = ciudadpue.nombre
            tvGrados?.text = ciudadpue.grados.toString()+ "°"
            tvEstatus?.text = ciudadpue.estatus

        }else{
            Toast.makeText(this,"No hay información", Toast.LENGTH_SHORT).show()
        }
    }
}