package `in`.learning.aabhasjindal.newsapp.ui.modules

import `in`.learning.aabhasjindal.newsapp.R
import `in`.learning.aabhasjindal.newsapp.data.model.database.Headline
import `in`.learning.aabhasjindal.newsapp.ui.base.BaseFragment
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [DetailedNewsFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [DetailedNewsFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class DetailedNewsFragment : BaseFragment(), View.OnClickListener {

    lateinit var image: ImageView
    lateinit var header: TextView
    lateinit var content: TextView
    lateinit var link: TextView

    override fun getLayout() = R.layout.fragment_detailed_news

    override fun resumeBundle() {
        arguments?.let {
            param1 = it.getParcelable(ARG_PARAM1)
        }
    }

    override fun initUI(view: View?) {
        image = view!!.findViewById(R.id.iv_image)
        header = view.findViewById(R.id.tv_header)
        content = view.findViewById(R.id.tv_content)
        link = view.findViewById(R.id.tv_source_link)

        setViews()
    }

    private fun setViews() {
        header.text = param1!!.title
        content.text = param1!!.content
        Picasso.with(getContentActivity())
            .load(param1!!.urlToImage)
            .error(R.drawable.ic_info_outline_black_24dp)
            .into(image)
        setUrlLink(link)
    }

    private fun setUrlLink(link: TextView) {
        val spannableString = SpannableString(String.format("Link - %s", param1!!.url))
        spannableString.setSpan(
            ForegroundColorSpan(Color.BLUE),
            7,
            param1!!.url!!.length + 7,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        link.text = spannableString
    }

    override fun attachListeners() {
        link.setOnClickListener(this)
    }

    // TODO: Rename and change types of parameters
    private var param1: Headline? = null

    override fun onClick(v: View?) {
        val bundle = bundleOf("url" to param1!!.url)
        getContentActivity().navHost.navController.navigate(R.id.webView, bundle)
    }

    companion object {

        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private const val ARG_PARAM1 = "headline"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @return A new instance of fragment DetailedNewsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(headline: Headline) =
            DetailedNewsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1, headline)
                }
            }
    }
}
