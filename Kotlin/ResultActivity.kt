package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Get the name of the player from the first screen, and show it.
        val username = intent.getStringExtra(Constants.USER_NAME)
        player_text.text = "Congratulations ${username}!"
        // if any problem occurs from getting the result from the first screen, we need to show the 0
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        score_field.text = "Your score is $correctAnswers out of $totalQuestions"
    }
}