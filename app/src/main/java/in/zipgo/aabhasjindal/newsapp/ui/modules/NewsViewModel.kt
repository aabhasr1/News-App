package `in`.zipgo.aabhasjindal.newsapp.ui.modules

import `in`.zipgo.aabhasjindal.newsapp.data.model.Headlines
import `in`.zipgo.aabhasjindal.newsapp.data.model.database.Headline
import `in`.zipgo.aabhasjindal.newsapp.data.network.NetworkSubscriber
import `in`.zipgo.aabhasjindal.newsapp.data.network.api_groups.Api
import `in`.zipgo.aabhasjindal.newsapp.data.rx.ObservableUtils
import `in`.zipgo.aabhasjindal.newsapp.data.rx.Variable
import `in`.zipgo.aabhasjindal.newsapp.ui.base.BaseViewModel
import javax.inject.Inject

class NewsViewModel : BaseViewModel() {

    var headlines: ArrayList<Headline>? = null

    var dataFetched = Variable(false)

    @Inject
    lateinit var api: Api

    fun getNews() {
        api.getHeadlines("in").compose(
            ObservableUtils
                .applyIoSchedulers()
        )
            .subscribe(object : NetworkSubscriber<Headlines>(this) {
                override fun onNextData(apiResponse: Headlines) {
                    headlines = apiResponse.toHeadLinesList()
                    dataFetched.value = true
                }

                override fun onErrorData(t: Throwable) {
                }

                override fun onServerError(string: String) {
                }

                override fun onFinished() {
                }
            })
    }

    fun getDataFromStorage() {

    }
}