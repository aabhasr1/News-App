package `in`.zipgo.aabhasjindal.newsapp.ui

import `in`.zipgo.aabhasjindal.newsapp.R
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }
}