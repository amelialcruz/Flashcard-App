package com.example.flashcardsample

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.flashcardsample.R

class MainActivity : AppCompatActivity() {
    //added listener to onCreate, as if it is not, it will not do anything
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //referencing values for question and answer by TextView, reset
        val flashQuestion = findViewById<TextView>(R.id.flashcardQuestion)
        val flashAnswer = findViewById<TextView>(R.id.flashcardAnswer)
        val oneColor = findViewById<TextView>(R.id.answerOne)
        val twoColor = findViewById<TextView>(R.id.answerTwo)
        val threeColor = findViewById<TextView>(R.id.answerThree)
        val resetEnable = findViewById<Button>(R.id.reset)
        val hide = findViewById<ImageView>(R.id.hide)
        var hideClick = 0


        //when the question is pressed, hide the question and show answer in its place
        flashQuestion.setOnClickListener {
            flashQuestion.visibility = View.INVISIBLE
            flashAnswer.visibility = View.VISIBLE
        }

        //when the answer is pressed, hide the answer and show question in its place
        flashAnswer.setOnClickListener {
            flashQuestion.visibility = View.VISIBLE
            flashAnswer.visibility = View.INVISIBLE
        }

        //when answer one choice selected, display background to red and answer three choice green
        oneColor.setOnClickListener {
            oneColor.setBackgroundColor(resources.getColor(R.color.pastel_red))
            oneColor.setTextColor(Color.WHITE)
            threeColor.setBackgroundColor(resources.getColor(R.color.pastel_green))
        }

        //when answer two choice selected, display background to red and answer three choice green
        twoColor.setOnClickListener {
            twoColor.setBackgroundColor(resources.getColor(R.color.pastel_red))
            twoColor.setTextColor(Color.WHITE)
            threeColor.setBackgroundColor(resources.getColor(R.color.pastel_green))
        }

        //when answer three choice selected, display background green
        threeColor.setOnClickListener {
            threeColor.setBackgroundColor(resources.getColor(R.color.pastel_green))
        }

        //when reset pressed, original background colors
        resetEnable.setOnClickListener {
            findViewById<TextView>(R.id.answerOne).setBackgroundColor(resources.getColor(R.color.lightest_blue))
            findViewById<TextView>(R.id.answerTwo).setBackgroundColor(resources.getColor(R.color.lightest_blue))
            findViewById<TextView>(R.id.answerThree).setBackgroundColor(resources.getColor(R.color.lightest_blue))
        }

        //hiding answers when icon clicked, changing icon
        hide.setOnClickListener {
            oneColor.visibility = View.INVISIBLE
            twoColor.visibility = View.INVISIBLE
            threeColor.visibility = View.INVISIBLE
            findViewById<ImageView>(R.id.hide).setImageResource(R.drawable.view)
            hideClick += 1

            //using var hideClick for showing answers again, changing icon
            if ( hideClick % 2 == 0)
            {
                oneColor.visibility = View.VISIBLE
                twoColor.visibility = View.VISIBLE
                threeColor.visibility = View.VISIBLE
                findViewById<ImageView>(R.id.hide).setImageResource(R.drawable.visible)
            }
        }

    }
}