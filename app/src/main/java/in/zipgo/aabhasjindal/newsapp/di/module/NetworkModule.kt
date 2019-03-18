package `in`.zipgo.aabhasjindal.newsapp.di.module

import `in`.zipgo.aabhasjindal.newsapp.BuildConfig
import `in`.zipgo.aabhasjindal.newsapp.data.network.api_groups.Api
import `in`.zipgo.aabhasjindal.newsapp.di.scope.AppScope
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import javax.inject.Singleton

@Module(includes = [NetworkLayer::class])
class NetworkModule {

    val gson: Gson
        @AppScope
        @Provides
        get() {
            Timber.d("provides getGson")
            val gsonBuilder = GsonBuilder()
            return gsonBuilder.create()
        }

    @AppScope
    @Provides
    fun getAuthApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }
//
//    @AppScope
//    @Provides
//    fun getMainApi(retrofit: Retrofit): MainApi {
//        return retrofit.create(MainApi::class.java)
//    }
//
//
//    @AppScope
//    @Provides
//    fun getAuthApiNew(retrofit: Retrofit): AuthApi {
//        return retrofit.create(AuthApi::class.java)
//    }
//
//    @AppScope
//    @Provides
//    fun getWalletApi(retrofit: Retrofit): WalletApi {
//        Log.d("Testing", "provides walletApi")
//        return retrofit.create(WalletApi::class.java)
//    }
//
//
//    @AppScope
//    @Provides
//    fun getBookingApi(retrofit: Retrofit): BookingApi {
//        Log.d("Testing", "provides BookingApi")
//        return retrofit.create(BookingApi::class.java)
//    }


    @Singleton
    @Provides
    fun getRetrofit(okHttpClient: OkHttpClient): Retrofit {
        Log.d("TEST_TARAS", "provides getRetrofit")
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .baseUrl(BuildConfig.API_URL)
            .build()
    }
}
