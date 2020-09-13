package com.example.quizzapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN // Removing the top bar
        val username = intent.getStringExtra("username")
        tv_username.text = username
        val totalQuestion = intent.getStringExtra("totalquestions")
        val answers = intent.getStringExtra("correctanswers")
        tv_mark.text = "You scored $answers / $totalQuestion"
        btn_finish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}