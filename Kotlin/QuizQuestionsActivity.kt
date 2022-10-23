package com.example.quizapp

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
import kotlinx.android.synthetic.main.activity_quiz_questions.*

//all the buttons has OnClickListener properties, so we rather implement the Click method to all of that, than make a class for all of them.
class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedQuestionPosition : Int = 0
    private var mCorrectAnswers: Int = 0
    private var mUserName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        mUserName = intent.getStringExtra(Constants.USER_NAME)
        mQuestionsList = Constants.getQuestions()

        setQuestion()

        quiz_option_one.setOnClickListener(this)
        quiz_option_two.setOnClickListener(this)
        quiz_option_three.setOnClickListener(this)
        quiz_option_four.setOnClickListener(this)

        btn_submit_answer.setOnClickListener(this)
    }

    private fun setQuestion() {

        val question = mQuestionsList!![mCurrentPosition-1]

        // we set first all of the questions to a default view, so we can modify the selected ones.
        defaultOptionsView()

        // After we set the new Question, everytime we set the buttons text back, to Submit, unless in last question it will be Finish
        if(mCurrentPosition == mQuestionsList!!.size) {
            btn_submit_answer.text = "Finish"
        } else {
            btn_submit_answer.text = "Submit"
        }


        progress_bar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progress_bar.max

        quiz_questions_text.text = question!!.question
        quiz_option_one.text=question.optionOne;
        quiz_option_one.text=question.optionTwo;
        quiz_option_one.text=question.optionThree;
        quiz_option_one.text=question.optionFour;
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0, quiz_option_one)
        options.add(1, quiz_option_two)
        options.add(2, quiz_option_three)
        options.add(3, quiz_option_four)

        for( option in options ) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            // with ContextCompat we can retrieve resources from drawable, or color, etc.
            option.background = ContextCompat.getDrawable(
                // we need to assign the context to that specific element
                this, R.drawable.default_option_border_bg
            )
        }
    }

    override fun onClick(v: View?) {
        //For every selected answer buttons, call that view, with the ID, and change its view.
        when(v?.id) {
            R.id.quiz_option_one -> {
                selectedOptionView(quiz_option_one, 1)
            }
            R.id.quiz_option_two -> {
                selectedOptionView(quiz_option_two, 2)
            }
            R.id.quiz_option_three -> {
                selectedOptionView(quiz_option_three, 3)
            }
            R.id.quiz_option_one -> {
                selectedOptionView(quiz_option_four, 4)
            }
            R.id.btn_submit_answer -> {
                if(mSelectedQuestionPosition == 0 ) {
                    mCurrentPosition++
                    when {
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            // Pass the username from the first Screen onto the last one, and the amount of questions, and correct
                            // answers, from the second screen to the last one.
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                        }
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition -1)
                    if(question!!.correctAnswer != mSelectedQuestionPosition) {
                        answerView(mSelectedQuestionPosition, R.drawable.incorrect_option_border_bg)
                    } else {
                        //Everytime we miss a correct answer, we got a point
                        mCorrectAnswers ++
                    }
                    // the correct answer is selected, and it become green, no matter if the user chose it correctly, or not.
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)
                    if(mCurrentPosition == mQuestionsList!!.size) {
                        // if we are at the end of the quiz, the button shows, that we are at the end of the quiz,
                        // otherwise we just step to the next question
                        btn_submit_answer.text = "Finish Quiz"
                    } else {
                        btn_submit_answer.text = "Next Question"
                    }
                    // Need to set to starting position the null everytime we start the next question.
                    mSelectedQuestionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when(answer) {
            1 -> quiz_option_one.background = ContextCompat.getDrawable(
                this, drawableView
            )
            2 -> quiz_option_two.background = ContextCompat.getDrawable(
                this, drawableView
            )
            3 -> quiz_option_three.background = ContextCompat.getDrawable(
                this, drawableView
            )
            4 -> quiz_option_four.background = ContextCompat.getDrawable(
                this, drawableView
            )
        }
    }

    //change the View of the selected answer, paint it, and change according to which is selected
    private fun selectedOptionView(tv: TextView,
                                   selectedOptionNum: Int) {
        defaultOptionsView()
        mSelectedQuestionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        // with ContextCompat we can retrieve resources from drawable, or color, etc.
        tv.background = ContextCompat.getDrawable(
            // we need to assign the context to that specific element
            this, R.drawable.selected_option_border_bg
        )
    }
}