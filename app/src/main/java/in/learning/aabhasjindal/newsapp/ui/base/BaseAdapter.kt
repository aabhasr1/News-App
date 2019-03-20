package `in`.learning.aabhasjindal.newsapp.ui.base

import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import java.util.*

abstract class BaseAdapter<T, V : View> : RecyclerView.Adapter<BaseViewWrapper<V>>() {

    var items: MutableList<T>? = mutableListOf()

    lateinit var clickListener: `in`.learning.aabhasjindal.newsapp.ui.modules.news.OnItemClickListener<T>

    var itemCount: Int? = null

    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): BaseViewWrapper<V> {
        return BaseViewWrapper(onCreateItemView(parent, viewType))
    }

    fun clearItems() {
        val size = items!!.size
        items = ArrayList()
        this.notifyItemRangeRemoved(0, size)
    }

    fun setOnClickListener(clickListener: `in`.learning.aabhasjindal.newsapp.ui.modules.news.OnItemClickListener<T>) {
        this.clickListener = clickListener
    }

    fun getDataItems(): List<T>? {
        return items
    }

    fun setDataItems(items: MutableList<T>) {
        this.items = items
        this.itemCount = items.size
        notifyDataSetChanged()
    }


    protected abstract fun onCreateItemView(parent: ViewGroup, viewType: Int): V
}