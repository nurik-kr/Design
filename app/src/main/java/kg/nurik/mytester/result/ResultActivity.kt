package kg.nurik.mytester.result

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kg.nurik.mytester.R
import kg.nurik.mytester.question.QuestionsActivity.Companion.POINTS
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val points = intent.getIntExtra(POINTS, -1)
        when {
            points <= 20 -> {
                changeFragment(R.layout.otvet_one)
            }
            points in 21..39 -> {
                changeFragment(R.layout.otvet_two)
            }
            points in 40..59 -> {
                changeFragment(R.layout.otvet_three)
            }
            points in 60..79 -> {
                changeFragment(R.layout.otvet_fourr)
            }
            points in 79..120 -> {
                changeFragment(R.layout.otvet_five)
            }
        }
        refresh.setOnClickListener {
            finish()
        }
    }

    private fun changeFragment(xml: Int) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, ResultFragment(xml))
            .commit()
    }
}