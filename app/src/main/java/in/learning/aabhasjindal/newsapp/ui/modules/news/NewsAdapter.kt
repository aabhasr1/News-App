package `in`.learning.aabhasjindal.newsapp.ui.modules.news

import `in`.learning.aabhasjindal.newsapp.R
import `in`.learning.aabhasjindal.newsapp.data.model.database.Headline
import `in`.learning.aabhasjindal.newsapp.ui.base.BaseAdapter
import `in`.learning.aabhasjindal.newsapp.ui.base.BaseViewWrapper
import android.view.LayoutInflater
import android.view.ViewGroup

class NewsAdapter(onItemClickListener: `in`.learning.aabhasjindal.newsapp.ui.modules.news.OnItemClickListener<Headline>) :
    BaseAdapter<Headline, NewsViewHolder>() {

    init {
        setOnClickListener(onItemClickListener)
    }

    override fun onCreateItemView(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_news_layout, parent, false
        )
        return NewsViewHolder(view, clickListener)
    }

    override fun getItemCount(): Int {
        return getDataItems()?.size ?: 0
    }

    override fun onBindViewHolder(holder: BaseViewWrapper<NewsViewHolder>, position: Int) {
        val viewHolder = holder.itemView as NewsViewHolder
        val headline = getDataItems()!![position]
        viewHolder.bind(headline, position)
    }
}