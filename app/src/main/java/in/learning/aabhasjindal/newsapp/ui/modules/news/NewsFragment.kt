package `in`.learning.aabhasjindal.newsapp.ui.modules.news


import `in`.learning.aabhasjindal.newsapp.R
import `in`.learning.aabhasjindal.newsapp.data.model.database.Headline
import `in`.learning.aabhasjindal.newsapp.data.rx.ObservableUtils
import `in`.learning.aabhasjindal.newsapp.ui.base.BaseFragment
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.facebook.shimmer.ShimmerFrameLayout
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 * Use the [NewsFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class NewsFragment : BaseFragment(), `in`.learning.aabhasjindal.newsapp.ui.modules.news.OnItemClickListener<Headline> {

    private lateinit var recyclerView: RecyclerView
    private lateinit var shimmerFrameLayout: ShimmerFrameLayout
    private lateinit var newsAdapter: NewsAdapter
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var newsViewModel: NewsViewModel

    override fun getLayout(): Int {
        return R.layout.fragment_news
    }


    override fun initUI(view: View?) {
        newsViewModel = ViewModelProviders.of(this, viewModelFactory)[NewsViewModel::class.java]
        newsViewModel.let { setViewModel(it) }
        recyclerView = view!!.findViewById(R.id.rv_news_list)
        swipeRefreshLayout = view.findViewById(R.id.swipeToRefresh)
        shimmerFrameLayout = view.findViewById(R.id.shimmer)
        swipeRefreshLayout.setColorSchemeColors(getContentActivity().resources.getColor(R.color.colorPrimary))
        recyclerView.layoutManager = LinearLayoutManager(getContentActivity())
        newsAdapter = NewsAdapter(this)
        recyclerView.adapter = newsAdapter
        recyclerView.visibility = View.INVISIBLE
        shimmerFrameLayout.visibility = View.VISIBLE
        newsViewModel.getNews()
    }

    override fun attachListeners() {
        addDisbosable(newsViewModel.dataFetched.observable
            .compose(ObservableUtils.applyIoSchedulers())
            .subscribe { dataRetrieved ->
                if (dataRetrieved) {
                    newsAdapter.setDataItems(newsViewModel.headlines!!)
                    recyclerView.visibility = View.VISIBLE
                    shimmerFrameLayout.visibility = View.GONE
                    newsViewModel.dataFetched.value = false
                    swipeRefreshLayout.isRefreshing = false
                }
            })
        swipeRefreshLayout.setOnRefreshListener {
            recyclerView.visibility = View.INVISIBLE
            shimmerFrameLayout.visibility = View.VISIBLE
            newsViewModel.getNews()
        }
    }

    override fun onItemClick(t: Headline?, position: Int) {
        val bundle = bundleOf("headline" to t)
        getContentActivity().navHost.navController.navigate(R.id.detailedNewsFragment, bundle)
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
