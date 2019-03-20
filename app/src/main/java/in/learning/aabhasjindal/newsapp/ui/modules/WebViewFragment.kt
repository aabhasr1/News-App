package `in`.learning.aabhasjindal.newsapp.ui.modules

import `in`.learning.aabhasjindal.newsapp.R
import `in`.learning.aabhasjindal.newsapp.ui.base.BaseFragment
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the [WebViewFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class WebViewFragment : BaseFragment() {

    lateinit var webView: WebView

    // TODO: Rename and change types of parameters
    private var param1: String? = null

    override fun getLayout() = R.layout.fragment_web_view

    override fun resumeBundle() {
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun initUI(view: View?) {
        webView = view!!.findViewById(R.id.wv_news)
        webView.settings.javaScriptEnabled = true
        webView.loadUrl(param1)
        webView.isHorizontalScrollBarEnabled = false

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                // do your handling codes here, which url is the requested url
                // probably you need to open that url rather than redirect:
                view.loadUrl(url)
                return false // then it is not handled by default action
            }
        }
    }

    override fun attachListeners() {
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private const val ARG_PARAM1 = "url"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @return A new instance of fragment WebViewFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(string: String) =
            WebViewFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, string)
                }
            }
    }
}
