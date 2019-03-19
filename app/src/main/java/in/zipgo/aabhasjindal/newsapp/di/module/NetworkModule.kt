package `in`.zipgo.aabhasjindal.newsapp.di.module

import `in`.zipgo.aabhasjindal.newsapp.BuildConfig
import `in`.zipgo.aabhasjindal.newsapp.data.network.api_groups.Api
import `in`.zipgo.aabhasjindal.newsapp.di.scope.AppScope
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [NetworkLayer::class])
class NetworkModule {

    @AppScope
    @Provides
    fun getAuthApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }


    @Singleton
    @Provides
    fun getRetrofit(okHttpClient: OkHttpClient) = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation().create()
            )
        )
            .client(okHttpClient)
            .baseUrl(BuildConfig.API_URL)
            .build()
}
