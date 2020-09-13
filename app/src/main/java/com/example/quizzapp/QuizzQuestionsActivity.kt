package com.example.quizzapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quizz_questions.*

class QuizzQuestionsActivity : AppCompatActivity(),View.OnClickListener {
    private var mCurrentPosition : Int = 1
    private var mQuestionList : ArrayList<Question>? = null
    private var mSelectedOptionPosition : Int = 0
    private var mCorrectAnswers :Int = 0
    var mUsername :String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        mUsername = intent.getStringExtra("username")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizz_questions)
        mQuestionList = Constants.getQuestions()
        //Log.i("Question Size","${questionList.size}") see the size in Logcat
        setQuestion()
        tv_option_1.setOnClickListener(this)
        tv_option_2.setOnClickListener(this)
        tv_option_3.setOnClickListener(this)
        tv_option_4.setOnClickListener(this)
        btn_submit.setOnClickListener(this)
    }
    private fun setQuestion(){
        val question : Question? = mQuestionList?.get(mCurrentPosition-1)
        defaultOptionsView()
        if (mCurrentPosition == mQuestionList?.size){
            btn_submit.text = "FINISH"
        }
        else{
            btn_submit.text = "SUBMIT"
        }
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
            R.id.btn_submit ->{
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition ++
                    when{
                        mCurrentPosition <= mQuestionList!!.size -> setQuestion()
                        else -> {
                            var intent = Intent(this,ResultActivity::class.java)
                            intent.putExtra("username",mUsername)
                            intent.putExtra("correctanswers",mCorrectAnswers.toString())
                            intent.putExtra("totalquestions",mQuestionList!!.size.toString())
                            startActivity(intent)
                    }

                }
                }
                else{
                    val question = mQuestionList?.get(mCurrentPosition-1)
                    if (question?.correctAnswer != mSelectedOptionPosition ){
                        answerView(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
                    }
                    else{
                        mCorrectAnswers ++
                    }
                    question?.correctAnswer?.let { answerView(it,R.drawable.correct_option_border_bg) }
                    if (mCurrentPosition == mQuestionList?.size ){
                        btn_submit.text = "FINISH"
                    }
                    else{
                        btn_submit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }
    private fun answerView(answer:Int,drawableView : Int){
        when(answer){
            1-> tv_option_1.background = ContextCompat.getDrawable(this,drawableView)
            2-> tv_option_2.background = ContextCompat.getDrawable(this,drawableView)
            3-> tv_option_3.background = ContextCompat.getDrawable(this,drawableView)
            4-> tv_option_4.background = ContextCompat.getDrawable(this,drawableView)
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