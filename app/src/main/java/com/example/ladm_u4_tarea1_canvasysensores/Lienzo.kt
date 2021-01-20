package com.example.ladm_u4_tarea1_canvasysensores

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import com.example.ladm_u4_tarea1_canvasysensores.R

class Lienzo (p: MainActivity): View(p){

    var hDia = true
    var puntero = p
    var posX = 150f
    var posY = 1400f

    override fun onDraw(c: Canvas) {
        super.onDraw(c)

        var p = Paint()


        if (hDia) {
            //Sol
            p.color = Color.YELLOW
            c.drawCircle(100f, 100f, 150f, p)



            //Montañas
            p.color = Color.rgb(72, 202, 49)
            c.drawCircle(2160f, 4500f, 3500f, p)
            p.color = Color.rgb(72, 202, 49)
            c.drawCircle(-1080f, 4500f, 3500f, p)
        }else{
            c.drawRGB(39,97,166)
            //Sol alunado
            p.color = Color.WHITE
            c.drawCircle(300f, 100f, 150f, p)

            //Montañas nigga
            p.color = Color.rgb(19, 67, 21)
            c.drawCircle(2160f, 4500f, 3500f, p)
            p.color = Color.rgb(19, 67, 21)
            c.drawCircle(-1080f, 4500f, 3500f, p)

        }


        //El pica pica
        c.drawBitmap(BitmapFactory.decodeResource(resources,
                R.drawable.charmander
        ), posX, posY, p)

    }
}