package `in`.learning.aabhasjindal.newsapp.ui.modules.news

import `in`.learning.aabhasjindal.newsapp.data.database.api.DatabaseApi
import `in`.learning.aabhasjindal.newsapp.data.model.ErrorDialogData
import `in`.learning.aabhasjindal.newsapp.data.model.Headlines
import `in`.learning.aabhasjindal.newsapp.data.model.database.Headline
import `in`.learning.aabhasjindal.newsapp.data.network.NetworkSubscriber
import `in`.learning.aabhasjindal.newsapp.data.network.api_groups.Api
import `in`.learning.aabhasjindal.newsapp.data.rx.DatabaseObservable
import `in`.learning.aabhasjindal.newsapp.data.rx.ObservableUtils
import `in`.learning.aabhasjindal.newsapp.data.rx.Variable
import `in`.learning.aabhasjindal.newsapp.ui.base.BaseViewModel
import android.util.Log
import javax.inject.Inject

class NewsViewModel @Inject constructor(val api: Api, val newsApi: DatabaseApi) : BaseViewModel() {

    var headlines: MutableList<Headline>? = null

    var dataFetched = Variable(false)

    fun getNews() {
        Log.d("NewsViewModel", "getting news")
        compositeDisposable.add(api.getHeadlines("in")
            .compose(ObservableUtils.applyIoSchedulers())
            .subscribeWith(object : NetworkSubscriber<Headlines>(this) {
                override fun onNextData(apiResponse: Headlines) {
                    val list = apiResponse.toHeadLinesList()
                    headlines = list
                    replaceDataInStorage(list)
                    dataFetched.value = true
                }

                override fun onErrorData(t: Throwable) {
                    getDataFromStorage()
                }

                override fun onServerError(string: String) {
                    getDataFromStorage()
                }

                override fun onFinished() {
                }
            }).unsetDialog()
        )
    }

    fun getDataFromStorage() {
        compositeDisposable.add(newsApi.getAllHeadlines()
            .compose(ObservableUtils.applyIoSingleSchedulers())
            .subscribeWith(object : DatabaseObservable<MutableList<Headline>>() {
                override fun onSuccessData(t: MutableList<Headline>) {
                    headlines = t
                    dataFetched.value = true
                }

                override fun onErrorData(t: Throwable) {
                    errorDialogData.value = (ErrorDialogData("Error " + t.cause, t.message))
                }
            })
        )
    }

    fun replaceDataInStorage(list: ArrayList<Headline>) {
        newsApi.nukeTable()
        newsApi.insertAllHeadLines(list)
    }
}