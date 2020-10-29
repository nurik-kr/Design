package kg.nurik.mytester.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class PagerDecorator: RecyclerView.ItemDecoration() { // вспомогатель для списков отступов чтоб не глючил

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val horizontalMargin = parent.context.dpToPx(16f)
        outRect.left = horizontalMargin
        outRect.right = horizontalMargin
    }
}