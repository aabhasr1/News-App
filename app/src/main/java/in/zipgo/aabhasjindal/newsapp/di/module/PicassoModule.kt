package `in`.zipgo.aabhasjindal.newsapp.di.module

import android.content.Context
import com.jakewharton.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient


@Module(includes = [NetworkLayer::class])
class PicassoModule {
    @Provides
    fun getPicasso(context: Context, okHttp3Downloader: OkHttp3Downloader): Picasso {
        val picasso = Picasso.Builder(context).downloader(okHttp3Downloader).build()
        Picasso.setSingletonInstance(picasso)
        return picasso
    }

    @Provides
    fun getOkHttp3Downloader(okHttpClient: OkHttpClient) = OkHttp3Downloader(okHttpClient)
}
