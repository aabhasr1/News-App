package `in`.zipgo.aabhasjindal.newsapp

import android.content.Context
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class NewsApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this)
            .build()
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
    }
}
