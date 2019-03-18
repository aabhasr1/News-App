package `in`.zipgo.aabhasjindal.newsapp.data.preferences

import android.content.Context
import android.content.SharedPreferences

open class BasePreference(context: Context) {
    protected val mPrefs: SharedPreferences

    init {
        mPrefs = context.getSharedPreferences(PREFERENCE_FILE, Context.MODE_PRIVATE)
    }

    companion object {
        private val PREFERENCE_FILE = "AGENT_DRIVER_PREFERENCE"
    }
}