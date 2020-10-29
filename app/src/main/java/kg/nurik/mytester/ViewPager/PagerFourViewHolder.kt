package kg.nurik.mytester.ViewPager

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kg.nurik.mytester.R
import kotlinx.android.synthetic.main.item_questions.view.tvCount
import kotlinx.android.synthetic.main.three_layout.view.*

class PagerFourViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    @SuppressLint("SetTextI18n")
    fun bind(s: String, position: Int, size: Int, listener: PagerListener) {
        itemView.tvCount.text =
            itemView.context.resources.getString(R.string.question_number, position + 1, size)

        itemView.btnZero.setOnClickListener {
            listener.selectAnswerForQuestions(0, position)
        }
        itemView.btnOneToFive.setOnClickListener {
            listener.selectAnswerForQuestions(5, position)
        }
        itemView.btnFiveToTen.setOnClickListener {
            listener.selectAnswerForQuestions(10, position)
        }
        itemView.btnTenToFiveten.setOnClickListener {
            listener.selectAnswerForQuestions(15, position)
        }
    }
}