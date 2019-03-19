package `in`.zipgo.aabhasjindal.newsapp.data.network.api_groups

import `in`.zipgo.aabhasjindal.newsapp.BuildConfig
import `in`.zipgo.aabhasjindal.newsapp.data.model.Headlines
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Part

interface Api {
    @GET("/docs/endpoints/top-headlines")
    fun getHeadlines(
        @Part("country") country: String,
        @Part("apiKey") apiKey: String = BuildConfig.API_KEY
    ): Observable<Headlines>
}