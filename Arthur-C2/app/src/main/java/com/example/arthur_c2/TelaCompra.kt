package com.example.arthur_c2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class TelaCompra : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_compra)

        val raca1 = intent.getStringExtra("raca1")
        val preco1 = intent.getIntExtra("preco1", 0)

        val raca2 = intent.getStringExtra("raca2")
        val preco2 = intent.getIntExtra("preco2", 0)

        val textId1: TextView = findViewById(R.id.tv_dog1)
        val textId2: TextView = findViewById(R.id.tv_dog2)
        val textPreco : TextView = findViewById(R.id.tv_resultadoCompra)

        val precoMedio = (preco1 + preco2)

        if(raca1  != null){
            textId1.setText("Cachorro 1: ${raca1}")
        }
        else{
            textId1.setText("Cachorro 1: Não Encontrado")
        }

        if(raca2  != null){
            textId2.setText("Cachorro 2: ${raca2}")
        }
        else{
            textId2.setText("Cachorro 2: Não Encontrado")
        }


        textPreco.setText("Preço médio: R$${precoMedio}")

    }
}