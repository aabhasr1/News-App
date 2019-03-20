package `in`.learning.aabhasjindal.newsapp.ui

import `in`.learning.aabhasjindal.newsapp.R
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {
    lateinit var navHost: NavHostFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        navHost = supportFragmentManager.findFragmentById(R.id.nav_fragment) as NavHostFragment
    }
}