package `in`.learning.aabhasjindal.newsapp

import `in`.learning.aabhasjindal.newsapp.di.DaggerAppComponent
import android.content.Context
import android.util.Log
import com.facebook.stetho.Stetho
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class NewsApp : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        Log.d("NewsApp", "app starting")
        Stetho.initializeWithDefaults(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this)
            .build()
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
    }
}
