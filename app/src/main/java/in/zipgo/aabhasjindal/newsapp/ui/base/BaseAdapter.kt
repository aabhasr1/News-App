package `in`.zipgo.aabhasjindal.newsapp.ui.base

import `in`.zipgo.aabhasjindal.newsapp.ui.modules.OnItemClickListener
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import java.util.*

abstract class BaseAdapter<T, V : View> : RecyclerView.Adapter<BaseViewWrapper<V>>() {

    var items: List<T>? = ArrayList()

    lateinit var clickListener: OnItemClickListener<T>

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

    fun setOnClickListener(clickListener: OnItemClickListener<T>) {
        this.clickListener = clickListener
    }

    fun getDataItems(): List<T>? {
        return items
    }

    fun setDataItems(items: List<T>) {
        this.items = items
        this.itemCount = items.size
        notifyDataSetChanged()
    }


    protected abstract fun onCreateItemView(parent: ViewGroup, viewType: Int): V
}