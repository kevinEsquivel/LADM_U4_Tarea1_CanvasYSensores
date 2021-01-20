package com.example.ladm_u4_tarea1_canvasysensores

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), SensorEventListener {

    var miLienzo : Lienzo?= null
    lateinit var sensorManager : SensorManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Servicio sensor
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        //Sensor de proximidad
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY), SensorManager.SENSOR_DELAY_NORMAL)
        //Acelerometro
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL)


        miLienzo = Lienzo(this)
        setContentView(miLienzo)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {
        var posX = event!!.values[0]

        // Cuando el acelerometro cambie por el susuario entonces empieza el movimiento
        if(event!!.sensor.type == Sensor.TYPE_ACCELEROMETER) {

            miLienzo!!.posX = miLienzo!!.posX + (-posX * 5)
        }
        // Cuando el sensor de proximidad detecte tope, entonces a la noche
        if(event!!.sensor.type == Sensor.TYPE_PROXIMITY) {
            miLienzo!!.hDia = (event.values[0] >= 1f)
        }

        miLienzo!!.invalidate()
    }
}
