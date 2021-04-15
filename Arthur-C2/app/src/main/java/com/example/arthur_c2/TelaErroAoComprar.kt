package com.example.arthur_c2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class TelaErroAoComprar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_erro)

        val id = intent.getStringExtra("id1")
        val id2 = intent.getStringExtra("id2")
        val mensagem : TextView = findViewById(R.id.tv_resposta_erro)
        mensagem.setText("Deu ruim... Nenhum cachorro encontrado com o id ${id} e id  ${id2}")
    }
}