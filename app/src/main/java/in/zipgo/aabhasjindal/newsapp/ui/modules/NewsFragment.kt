package `in`.zipgo.aabhasjindal.newsapp.ui.modules


import `in`.zipgo.aabhasjindal.newsapp.R
import `in`.zipgo.aabhasjindal.newsapp.data.model.database.Headline
import `in`.zipgo.aabhasjindal.newsapp.ui.base.BaseFragment
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 * Use the [NewsFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class NewsFragment : BaseFragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var newsAdapter: NewsAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    @Inject
    lateinit var newsViewModel: NewsViewModel

    override fun getLayout(): Int {
        return R.layout.fragment_news
    }


    override fun initUI(view: View?) {
        newsViewModel.let { setViewModel(it) }
        recyclerView = view!!.findViewById(R.id.rv_news_list)
        recyclerView.layoutManager = LinearLayoutManager(getContentActivity())
        newsAdapter = NewsAdapter(OnItemClickListener { t: Headline?, position: Int ->
            //todo open next fragment with data passed
        })

        newsViewModel.getNews()
    }

    override fun attachListeners() {
        addDisbosable(newsViewModel.dataFetched.observable.subscribe { dataRetrieved ->
            if (dataRetrieved) {
                newsAdapter.setDataItems(newsViewModel.headlines!!.toList())
            }
        })
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment NewsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            NewsFragment()
    }
}
