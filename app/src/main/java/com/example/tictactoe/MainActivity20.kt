package com.example.tictactoe

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main20.*
import kotlinx.android.synthetic.main.activity_start.*

class MainActivity20 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main20)
        easy.setOnClickListener {
            val intent= Intent(this,MainActivity1::class.java)
            startActivity(intent)
        }
        hard.setOnClickListener {
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }


    }
}
