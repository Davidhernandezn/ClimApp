package com.davidhernandezn.climapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import java.lang.Exception

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

        if (Network.hayRed(this)){
            //Ejecutar solicitud HTTP
            solicitudHTTPVolley("http://api.openweathermap.org/data/2.5/weather?id="+ciudad+"&lang=es&appid=94f33425a7ee23ff6009cb5f3b6f11fe&units=metric")
        }else{
            //Mensaje de error
            Toast.makeText(this,"No se hay red", Toast.LENGTH_SHORT).show()
        }
/**

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

**/}
//Metodo volley
private fun solicitudHTTPVolley(url:String){
    //funciona con estructura estac, de cola reciber solicitud las maneja como llegan orden
    //administra solicitudes a la vez
    val queue = Volley.newRequestQueue(this)
    val solicitud = StringRequest(Request.Method.GET, url, Response.Listener <String>{
            response ->
        try {
            //Operaciones para procesar solicitud
            Log.d("solicitudHTTPVolley", response)
            //nuevo obketp
            val gson = Gson()
            val ciudad = gson.fromJson(response, Ciudad::class.java)
            //Log.d("GSON", ciudad.name)
            tvCiudad?.text = ciudad.name
            tvGrados?.text = ciudad.main?.temp.toString() + "°"
            tvEstatus?.text = ciudad.weather?.get(0)?.description //objeto verifica donde esta
        }catch (e: Exception){

        }
    }, Response.ErrorListener {  })
    queue.add(solicitud)
}
}