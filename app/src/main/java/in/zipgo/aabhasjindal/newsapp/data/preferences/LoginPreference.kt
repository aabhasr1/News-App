package `in`.zipgo.aabhasjindal.newsapp.data.preferences

import android.content.Context
import javax.inject.Inject

class LoginPreference @Inject constructor(context: Context) : BasePreference(context) {
    private val ACCESS_TOKEN = "access_token"
    private val LOGIN = "login"
    private val PASSWORD = "password"
    private val AGENT_ID = "agent_id"
    private val IS_SHORT_TOKEN = "is_short_token"
    private val IS_POSTPAID = "is_post_paid"
    private val SEEN_FUI = "seen_fui"

    var accessToken: String?
        get() = mPrefs.getString(ACCESS_TOKEN, null)
        set(access_token) {
            val editor = mPrefs.edit()
            editor.putString(ACCESS_TOKEN, access_token)
            editor.apply()
        }

    var login: String?
        get() = mPrefs.getString(LOGIN, null)
        set(login) {
            if (login.isNullOrEmpty()) return
            val editor = mPrefs.edit()
            editor.putString(LOGIN, login)
            editor.apply()
        }

    var password: String?
        get() = mPrefs.getString(PASSWORD, null)
        set(password) {
            if (password.isNullOrEmpty()) return
            val editor = mPrefs.edit()
            editor.putString(PASSWORD, password)
            editor.apply()
        }

    var agentId: String?
        get() = mPrefs.getString(AGENT_ID, null)
        set(agentId) {
            if (agentId.isNullOrEmpty()) return
            val editor = mPrefs.edit()
            editor.putString(AGENT_ID, agentId)
            editor.apply()

        }

    val isShortToken: Boolean
        get() = mPrefs.getBoolean(IS_SHORT_TOKEN, false)

    val isAccountPostPaid: Boolean
        get() = mPrefs.getBoolean(IS_POSTPAID, false)

    fun setIS_SHORT_TOKEN(isShort: Boolean) {
        val editor = mPrefs.edit()
        editor.putBoolean(IS_SHORT_TOKEN, isShort)
        editor.apply()
    }

    fun clearPreference() {
        val editor = mPrefs.edit()
        editor.clear()
        editor.apply()
    }

    fun setAccountType(type: Boolean) {
        val editor = mPrefs.edit()
        editor.putBoolean(IS_POSTPAID, type)
        editor.apply()
    }

    fun seenFUI(): Boolean {
        return mPrefs.getBoolean(SEEN_FUI, false)
    }

    fun setFUI() {
        val editor = mPrefs.edit()
        editor.putBoolean(SEEN_FUI, true)
        editor.apply()
    }

}