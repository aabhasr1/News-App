package `in`.learning.aabhasjindal.newsapp.ui.base

import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Nickname on 30.11.18.
 */
abstract class BaseViewHolder<T>(
    val view: View,
    var onItemClickListener: `in`.learning.aabhasjindal.newsapp.ui.modules.news.OnItemClickListener<T>
) :
    LinearLayout(view.context) {

    init {
        this.addView(view)
        this.layoutParams = RecyclerView.LayoutParams(
            RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT
        )

        initUI()
    }

    protected abstract fun initUI()

}