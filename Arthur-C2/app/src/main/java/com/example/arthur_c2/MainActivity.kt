package com.example.arthur_c2

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import com.example.arthur_c2.models.Cachorro
import com.example.arthur_c2.network.Conection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun comprar(view: View) {
        val api = Conection.criar()
        val etid1: EditText = findViewById(R.id.id1)
        val etid2: EditText = findViewById(R.id.id2)

        val intentErro = Intent (this, TelaErroAoComprar::class.java)
        val intent = Intent (this, TelaCompra::class.java)

        val s :SwitchCompat = findViewById(R.id.switch1)

        val id1 = etid1.text.toString().toInt()
        val id2 = etid2.text.toString().toInt()


        val b : String
        if(s.isChecked){
            b = "true"
        }
        else{
            b = "false"
        }

       var existe1 : Boolean = true
       var existe2 : Boolean = true

        //Requisitando o primeiro cachorro
        api.get(id1).enqueue(object : Callback<Cachorro> {
            override fun onResponse(call: Call<Cachorro>, response: Response<Cachorro>) {
                if (response.code().toString() == "200" && response.body()?.indicadoCriancas.toString() == b){
                    val raca:String? = response.body()?.raca
                    val preco:Int? = response.body()?.precoMedio?.toInt()

                    intent.putExtra("raca1", raca)
                    intent.putExtra("preco1" , preco)
                    startActivity(intent)

                } else {
                    intentErro.putExtra("id1", id1.toString())
                    startActivity(intentErro)
                    //existe1 = false
                }
            }

            override fun onFailure(call: Call<Cachorro>, t: Throwable) {
                Toast.makeText(baseContext, "Não consegui conectar na API", Toast.LENGTH_SHORT).show()
            }
        })

        //Requisitando o segundo cachorro
        api.get(id2).enqueue(object : Callback<Cachorro> {
            override fun onResponse(call: Call<Cachorro>, response: Response<Cachorro>) {
                if (response.code().toString() == "200" && response.body()?.indicadoCriancas.toString() == b) {

                    val raca:String? = response.body()?.raca
                    val preco:Int? = response.body()?.precoMedio?.toInt()

                    intent.putExtra("raca2", raca)
                    intent.putExtra("preco2" , preco)
                    startActivity(intent)

                } else {
                    intentErro.putExtra("id2", id2.toString())
                    startActivity(intentErro)
                }
            }

            override fun onFailure(call: Call<Cachorro>, t: Throwable) {
                Toast.makeText(baseContext, "Não consegui conectar na API", Toast.LENGTH_SHORT).show()
            }
        })


    }
}