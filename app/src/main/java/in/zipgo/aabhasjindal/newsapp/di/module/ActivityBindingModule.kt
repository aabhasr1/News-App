package `in`.zipgo.aabhasjindal.newsapp.di.module

import `in`.zipgo.aabhasjindal.newsapp.di.scope.ActivityScoped
import `in`.zipgo.aabhasjindal.newsapp.di.scope.FragmentScoped
import `in`.zipgo.aabhasjindal.newsapp.ui.main.MainActivity
import `in`.zipgo.aabhasjindal.newsapp.ui.modules.SplashFragment
import `in`.zipgo.aabhasjindal.newsapp.ui.modules.auth.SignInFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * We want Dagger.Android to create a Subcomponent which has a parent Component of whichever module ActivityBindingModule is on,
 * in our case that will be AppComponent. The beautiful part about this setup is that you never need to tell AppComponent that it is going to have all these subcomponents
 * nor do you need to tell these subcomponents that AppComponent exists.
 * We are also telling Dagger.Android that this generated SubComponent needs to include the specified modules and be aware of a scope annotation @ActivityScoped
 * When Dagger.Android annotation processor runs it will create 4 subcomponents for us.
 */
@Module
abstract class ActivityBindingModule {

//    @ActivityScoped
//    @ContributesAndroidInjector(modules = [SplashModule::class])
//    internal abstract fun splashActivity(): SplashActivity
//
//    @ActivityScoped
//    @ContributesAndroidInjector(modules = [AuthModule::class])
//    internal abstract fun authActivity(): AuthActivity

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun app(): MainActivity

    //    @JvmStatic
    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun signInFragment(): SignInFragment

    //    @JvmStatic
    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun splashFragment(): SplashFragment
}