package com.bignerdranch.android.geomain

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bignerdranch.android.geomain.ui.theme.GeoQuizTheme

class MainActivity : AppCompatActivity() {
    private lateinit var buttonYes: Button
    private lateinit var buttonNo: Button
    private lateinit var buttonNext:Button
    private lateinit var textview1:TextView
    private val questionBank = listOf(
        Question(R.string.question_text1,true),
        Question(R.string.question_text2,true),
        Question(R.string.question_text3,true),
        Question(R.string.question_text4,false),
        Question(R.string.question_text5,false),
        Question(R.string.question_text6,false))

    private var currentindex = 0


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonYes = findViewById(R.id.buttonYes)
        buttonNo = findViewById(R.id.buttonNo)
        buttonNext = findViewById(R.id.buttonNext)
        textview1 = findViewById(R.id.textview1)
        buttonYes.setOnClickListener {
            checkAnswer(true)
        }
        buttonNo.setOnClickListener {
            checkAnswer(false)
        }


        if(currentindex<questionBank.size) {
            buttonNext.setOnClickListener {
                currentindex = (currentindex + 1)
                updateQuestion()
            }
        }

    }

    private fun updateQuestion()
    {
        val questionTextResId = questionBank[currentindex].textResId
        textview1.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer: Boolean)
    {
        val correctAnswer =  questionBank[currentindex].answer
        val messageId = if (userAnswer == correctAnswer)
        {R.string.correct}
        else {R.string.incorrect}

        val toast = Toast.makeText(this, messageId, Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.TOP,0,0)
        toast.show()

    }





    }


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GeoQuizTheme {
        Greeting("Android")
    }
}