package kg.nurik.mytester

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_questions.*

class QuestionsActivity : AppCompatActivity(), PagerListener {

    private val adapter by lazy {
        PagerAdapter(this)
    }
    private var questionResult = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        setupViewPager()
        setupListeners()
    }

    private fun setupListeners() {
        next.setOnClickListener {
            pager.currentItem += 1
        }
    }

    override fun onBackPressed() { // для кнопки назад
        if (pager.currentItem > 0) {
            pager.currentItem -= 1
        } else {
            super.onBackPressed()
        }
    }

    private fun setupViewPager() {
        pager.adapter = adapter
        pager.isUserInputEnabled = false
        pager.offscreenPageLimit = 6 //по дефолту хранит в себе 6 элементов

        adapter.update(generateData())
    }

    private fun generateData(): ArrayList<String> {
        val list = arrayListOf<String>()

        list.add(getString(R.string.two_str))
        list.add("второй вопрос")
        list.add("третий вопрос")
        list.add("третий вопрос")
        list.add("третий вопрос")

        return list
    }

    override fun selectAnswer(answer: Boolean, position: Int) {
        pager.currentItem += 1
        if (answer) questionResult += 20

        if (position + 1 == adapter.itemCount) {
//            startActivity()
        }
    }
}
