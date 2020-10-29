package kg.nurik.mytester.result

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kg.nurik.mytester.R
import kg.nurik.mytester.question.QuestionsActivity.Companion.POINTS

class ResultActivity : AppCompatActivity() {

//    private val points = intent.getIntExtra(POINTS, -1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val points = intent.getIntExtra(POINTS, -1)
        when {
            points <= 20 -> {
                setContentView(R.layout.otvet_one)
//                parentLayout.setBackgroundColor(R.drawable.bg_green_button)
            }
            points in 21..39 -> {
                setContentView(R.layout.otvet_two)
//                parentLayout.setBackgroundColor(R.drawable.bg_green_button)
            }
            points in 40..59 -> {
                setContentView(R.layout.otvet_three)
//                parentLayout.setBackgroundColor(R.drawable.bg_green_button)
            }
            points in 60..79 -> {
                setContentView(R.layout.otvet_one)
//                parentLayout.setBackgroundColor(R.drawable.bg_green_button)
            }
        }
//        val points = intent.getIntExtra(POINTS, -1)

//        when {
//            points <= 20 -> {
//                parentLayout.setBackgroundColor(R.drawable.bg_green_button)
//            }
//            points in 21..39 -> {
//                parentLayout.setBackgroundColor(R.drawable.bg_green_button)
//            }
//            points in 40..59 -> {
//                parentLayout.setBackgroundColor(R.drawable.bg_green_button)
//            }
//            points in 60..79 -> {
//                parentLayout.setBackgroundColor(R.drawable.bg_green_button)
//            }
//        }

    }
}