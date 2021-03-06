package kg.nurik.mytester.ViewPager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.nurik.mytester.R

class PagerAdapter(private val listener: PagerListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() { // мы указали родительский класс , который может принимать другой вьюХолдер

    private val list = arrayListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TWO_QUESTIONS) { // получается если позиция 2 то такая верстка
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_questions, parent, false)
            PagerViewPager(view)
        } else { // если позиция 4 то такая верстка
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.three_layout, parent, false)
            PagerFourViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == TWO_QUESTIONS) {
            (holder as PagerViewPager).bind(list[position], position, list.size, listener)
        } else {
            (holder as PagerFourViewHolder).bind(list[position], position, list.size, listener)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 2) FOUR_QUESTIONS //если позиция 4 то верстка такая , если 2 то такая верстка
        else TWO_QUESTIONS
    }

    fun update(list: ArrayList<String>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount() = list.size

    companion object {
        const val TWO_QUESTIONS = 12
        const val FOUR_QUESTIONS = 13
    }
}