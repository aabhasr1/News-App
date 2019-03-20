package `in`.learning.aabhasjindal.newsapp.di.module

import `in`.learning.aabhasjindal.newsapp.di.scope.AppScope
import android.content.Context
import android.util.Log
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File
import java.util.concurrent.TimeUnit

@Module(includes = [PreferenceModule::class])
class NetworkLayer {

    @AppScope
    @Provides
    fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor { message -> Log.d("NetworkLayer", message) }
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @AppScope
    @Provides
    fun getOkHttp(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        cache: Cache
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(65, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .retryOnConnectionFailure(true)
            .cache(cache)
            .build()
    }

    @AppScope
    @Provides
    fun getCache(file: File): Cache {
        return Cache(file, 1000 * 1000 * 100)
    }


    @AppScope
    @Provides
    fun getFile(context: Context): File {
        val file = File(context.cacheDir, "okhttp_cache")
        file.mkdir()
        return file
    }
}
