package com.example.quizzapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_quizz_questions.*

class QuizzQuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizz_questions)
        val questionList = Constants.getQuestions()
        //Log.i("Question Size","${questionList.size}") see the size in Logcat
        val currentPosition = 1
        val question : Question? = questionList[currentPosition-1]
        pb.progress = currentPosition
        tv_progress.text = "$currentPosition" + "/" + pb.max
        tv_question_id.text = question!!.question
        iv_image.setImageResource(question.image)
        tv_option_1.text = question.optionOne
        tv_option_2.text = question.optionTwo
        tv_option_3.text = question.optionThree
        tv_option_4.text = question.optionFour
    }
}