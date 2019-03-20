package `in`.learning.aabhasjindal.newsapp.di.module

import `in`.learning.aabhasjindal.newsapp.di.scope.FragmentScoped
import `in`.learning.aabhasjindal.newsapp.ui.modules.DetailedNewsFragment
import `in`.learning.aabhasjindal.newsapp.ui.modules.WebViewFragment
import `in`.learning.aabhasjindal.newsapp.ui.modules.news.NewsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun newsFragment(): NewsFragment

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun DetailedNewsFragment(): DetailedNewsFragment

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun webView(): WebViewFragment
}