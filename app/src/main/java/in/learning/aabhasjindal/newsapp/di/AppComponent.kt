package `in`.learning.aabhasjindal.newsapp.di

import `in`.learning.aabhasjindal.newsapp.NewsApp
import `in`.learning.aabhasjindal.newsapp.di.module.*
import `in`.learning.aabhasjindal.newsapp.di.scope.AppScope
import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@AppScope
@Component(modules = [NetworkModule::class, PicassoModule::class, PreferenceModule::class, ApplicationModule::class, ActivityBindingModule::class, AndroidSupportInjectionModule::class, ViewModelModule::class, DatabaseModule::class])
interface AppComponent : AndroidInjector<NewsApp> {

    // Gives us syntactic sugar. we can then do DaggerAppComponent.builder().application(this).build().inject(this);
    // never having to instantiate any modules or say which module we are passing the application to.
    // Application will just be provided into our app graph now.

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): AppComponent.Builder
        fun build(): AppComponent
    }
}
