package com.davidhernandezn.climapp

class Ciudad (name:String, weather:ArrayList<Weather>, main:Main){
    //Creamos variables a usar y los inicializamos, los nombres son como las tiene la API
    var name:String = ""
    var weather:ArrayList<Weather>? = null
    var main:Main? = null

    //Hacemos referencia a sus valores
    init {
        this.name = name
        this.weather = weather
        this.main = main
    }
}