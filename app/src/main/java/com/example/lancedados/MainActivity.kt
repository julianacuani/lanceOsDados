package com.example.lancedados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var botaoLancarDados = findViewById<Button>(R.id.lanceDadosBotao)
        var dado1 = findViewById<ImageView>(R.id.dado1)
        var dado2 = findViewById<ImageView>(R.id.dado2)


         botaoLancarDados.setOnClickListener {
          dado1.setImageResource(lançaDado())
          dado2.setImageResource(lançaDado())
      }
        val playerName = getIntent().getStringExtra("playerName")
        val playerNameTextView = findViewById<TextView>(R.id.playerNameText)
        playerNameTextView.text = "Hora de jogar. Boa sorte $playerName"
   }

    fun lançaDado(): Int {
        return recuperaFaceDado(geraNumero())
    }
      fun recuperaFaceDado(valor:Int): Int{
        return  when (valor){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
    fun geraNumero(): Int {
        return (1..6).random()
    }
}