package `in`.learning.aabhasjindal.newsapp.data.network.api_groups

import `in`.learning.aabhasjindal.newsapp.BuildConfig
import `in`.learning.aabhasjindal.newsapp.data.model.Headlines
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("/v2/top-headlines")
    fun getHeadlines(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY
    ): Observable<Headlines>
}