package com.example.quizzapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quizz_questions.*

class QuizzQuestionsActivity : AppCompatActivity(),View.OnClickListener {
    private var mCurrentPosition : Int = 1
    private var mQuestionList : ArrayList<Question>? = null
    private var mSelectedOptionPosition : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizz_questions)
        mQuestionList = Constants.getQuestions()
        //Log.i("Question Size","${questionList.size}") see the size in Logcat
        setQuestion()
        tv_option_1.setOnClickListener(this)
        tv_option_2.setOnClickListener(this)
        tv_option_3.setOnClickListener(this)
        tv_option_4.setOnClickListener(this)
    }
    private fun setQuestion(){
        mCurrentPosition = 1
        val question : Question? = mQuestionList?.get(mCurrentPosition-1)
        defaultOptionsView()
        pb.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + pb.max
        tv_question_id.text = question!!.question
        iv_image.setImageResource(question.image)
        tv_option_1.text = question.optionOne
        tv_option_2.text = question.optionTwo
        tv_option_3.text = question.optionThree
        tv_option_4.text = question.optionFour
    }
    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0,tv_option_1)
        options.add(1,tv_option_2)
        options.add(2,tv_option_3)
        options.add(3,tv_option_4)
        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_option_1 -> selectedOptionView(tv_option_1,1)
            R.id.tv_option_2 -> selectedOptionView(tv_option_2,2)
            R.id.tv_option_3 -> selectedOptionView(tv_option_3,3)
            R.id.tv_option_4 -> selectedOptionView(tv_option_4,4)
        }
    }
    private fun selectedOptionView(tv: TextView, selectedOptionNumber : Int){
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNumber
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border
        )
    }
}