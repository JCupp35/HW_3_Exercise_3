package com.bignerdranch.android.geoquiz

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.bignerdranch.android.geoquiz.databinding.ActivityMainBinding

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding



    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true))

    private var currentIndex = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,  "onCreate (Bundle?) called")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.trueButton.setOnClickListener {
            checkAnswer(true)
        }
        binding.falseButton.setOnClickListener {
            checkAnswer(false)
        }
        binding.nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            binding.trueButton.isEnabled = true
            binding.falseButton.isEnabled = true
            updateQuestion()
        }

        updateQuestion()
    }

        private fun updateQuestion() {
            val questionTextResId = questionBank[currentIndex].textResId
            binding.questionTextView.setText(questionTextResId)
        }

    private var correctAnswerCounter = 0
private fun checkAnswer(userAnswer: Boolean) {
    val correctAnswer = questionBank[currentIndex].answer

        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
            correctAnswerCounter++
            R.string.correct_toast
    } else {
        R.string.incorrect_toast
            R.string.incorrect_toast
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
            .show()

        binding.trueButton.isEnabled = false
        binding.falseButton.isEnabled = false

        if (currentIndex == questionBank.size - 1) {
            showScore()
            correctAnswerCounter = 0
        }
}

    private fun showScore() {
        val totalScore = (correctAnswerCounter.toDouble() / questionBank.size) * 100
        val totalScoreFormat = String.format("%.1f%%", totalScore)
        Toast.makeText(this, "Quiz Score: $totalScoreFormat", Toast.LENGTH_LONG).show()

    }

    override fun onStart(){
        super.onStart()
        Log.d(TAG, "onStart() called" )

    }
    override fun onResume(){
        super.onResume()
        Log.d(TAG, "onResume() called" )

    }
    override fun onPause(){
        super.onPause()
        Log.d(TAG, "onPause() called" )

    }
    override fun onStop(){
        super.onStop()
        Log.d(TAG, "onStop() called" )

    }
    override fun onDestroy(){
        super.onDestroy()
        Log.d(TAG, "onDestroy() called" )

    }

    }




