package com.example.quizzapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_result.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN // Removing the top bar
        btn_Start.setOnClickListener {
            if (et_name.text.toString().isEmpty()){
                Toast.makeText(this,"Enter your name please",Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this,QuizzQuestionsActivity::class.java)
                intent.putExtra("username", et_name.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}