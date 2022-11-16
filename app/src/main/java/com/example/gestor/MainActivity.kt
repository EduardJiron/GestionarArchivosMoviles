package com.example.gestor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bo:Button=findViewById(R.id.button)
        var bo2:Button=findViewById(R.id.button2)

        bo.setOnClickListener(){
            selecionarImagen()
        }

        bo2.setOnClickListener(){


            val intent = Intent(Intent.ACTION_CREATE_DOCUMENT).apply {
                addCategory(Intent.CATEGORY_OPENABLE)
                type = "text/plain"
                putExtra(Intent.EXTRA_TITLE, "prueba.txt")

            }
                startActivityForResult(intent, 1)


        }


    }
    private val galery=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result->
        val data=result.data?.data
        var image: ImageView =findViewById(R.id.imageView)
        image.setImageURI(data)

    }



    fun selecionarImagen(){
        val intent= Intent(Intent.ACTION_GET_CONTENT)
        intent.type="image/*"

        galery.launch(intent)

    }
}