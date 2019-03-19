package `in`.zipgo.aabhasjindal.newsapp.ui.base

import `in`.zipgo.aabhasjindal.newsapp.ui.modules.OnItemClickListener
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Nickname on 30.11.18.
 */
abstract class BaseViewHolder<T>(val view: View, var onItemClickListener: OnItemClickListener<T>) :
    LinearLayout(view.context), View.OnClickListener {

    init {
        this.addView(view)
        this.layoutParams = RecyclerView.LayoutParams(
            RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT
        )

        initUI()
        setListener()
    }

    protected abstract fun initUI()

    protected fun setListener() {

    }

    override fun onClick(view: View) {

    }

    protected abstract fun bind(t: T, position: Int)

}