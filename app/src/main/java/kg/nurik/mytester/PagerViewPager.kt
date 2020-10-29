package kg.nurik.mytester

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_questions.view.*

class PagerViewPager(view: View) : RecyclerView.ViewHolder(view) {
    @SuppressLint("SetTextI18n")
    fun bind(s: String, position: Int, size: Int, listener: PagerListener) {
        itemView.tvCount.text =
            itemView.context.resources.getString(R.string.question_number, position + 1, size)

        itemView.btnYes.setOnClickListener {
            listener.selectAnswer(true, position)
        }
        itemView.btnNo.setOnClickListener {
            listener.selectAnswer(false, position)
        }
    }
}