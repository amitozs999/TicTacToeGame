package com.example.tictactoe

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main1.*

class MainActivity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)
        easy1.setOnClickListener {
            val intent= Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
        medium1.setOnClickListener {
            val intent= Intent(this,MainActivity3::class.java)
            startActivity(intent)
        }
        hard1.setOnClickListener {
            val intent= Intent(this,MainActivity4::class.java)
            startActivity(intent)
        }
    }
}
