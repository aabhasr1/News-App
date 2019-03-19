package `in`.zipgo.aabhasjindal.newsapp.ui.modules

import `in`.zipgo.aabhasjindal.newsapp.R
import `in`.zipgo.aabhasjindal.newsapp.data.model.database.Headline
import `in`.zipgo.aabhasjindal.newsapp.ui.base.BaseViewHolder
import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

@SuppressLint("ViewConstructor")
class NewsViewHolder(view: View, onItemClickListener: OnItemClickListener<Headline>) :
    BaseViewHolder<Headline>(view, onItemClickListener) {
    lateinit var imageView: ImageView
    lateinit var header: TextView
    lateinit var description: TextView

    override fun initUI() {
        imageView = view.findViewById(R.id.iv_image)
        header = view.findViewById(R.id.iv_tv_header)
        description = view.findViewById(R.id.iv_tv_description)
    }

    public override fun bind(t: Headline, position: Int) {
        Picasso.with(context).load(t.urlToImage).error(R.drawable.ic_info_outline_black_24dp).into(imageView)
        header.text = t.title
        description.text = t.description
    }
}