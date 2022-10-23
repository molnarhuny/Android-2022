package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_start.setOnClickListener {
            if (player_name.toString().isEmpty())
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            else {
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                // when the game starts from the first screen, we can assign the name of the player from the first screen, to show it later
                intent.putExtra(Constants.USER_NAME, player_name.text.toString())
                startActivity(intent)
            }
        }
    }
}