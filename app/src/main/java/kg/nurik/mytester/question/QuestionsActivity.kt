package kg.nurik.mytester.question

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kg.nurik.mytester.ViewPager.PagerAdapter
import kg.nurik.mytester.ViewPager.PagerListener
import kg.nurik.mytester.R
import kg.nurik.mytester.result.ResultActivity
import kg.nurik.mytester.utils.PagerDecorator
import kg.nurik.mytester.utils.SpinnerTransformation
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
    }

    override fun onBackPressed() { // для кнопки назад
        if (pager.currentItem > 0) {
            pager.currentItem -= 1
        } else {
            super.onBackPressed()
            overridePendingTransition(R.anim.slide_left_out, R.anim.slide_right_out)
        }
    }

    private fun setupViewPager() {
        pager.adapter = adapter
        pager.isUserInputEnabled = false
        pager.setPageTransformer(SpinnerTransformation())
        pager.offscreenPageLimit = 6 //по дефолту хранит в себе 6 элементов
        pager.addItemDecoration(PagerDecorator()) // отступы для списков

        adapter.update(generateData())
    }

    private fun generateData(): ArrayList<String> {
        val list = arrayListOf<String>()

        list.add(getString(R.string.one_str))
        list.add(getString(R.string.two_str))
        list.add(getString(R.string.three_str))
        list.add(getString(R.string.four_str))
        list.add(getString(R.string.five_str))
        list.add(getString(R.string.six_str))

        return list
    }

    override fun selectAnswer(answer: Boolean, position: Int) {
        if (position < 4 && answer) questionResult += 20 // если да +20 баллов , если нет то ничего
        if (position >= 4 && !answer) questionResult += 20
        Log.d("asdasd",questionResult.toString())

        nextPage(position)
    }

    override fun selectAnswerForQuestions(points: Int, position: Int) {
        questionResult += points
        Log.d("asdasd",questionResult.toString())
        nextPage(position)
    }

    private fun nextPage(position: Int) {
        pager.currentItem += 1

        if (position + 1 == adapter.itemCount) { // логика такая если последний экран то запустить активи
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra(POINTS, questionResult) // сюда передаем баллы
            startActivity(intent)
            finish()
        }
    }

    companion object {
        const val POINTS = "POINTS"
    }
}
