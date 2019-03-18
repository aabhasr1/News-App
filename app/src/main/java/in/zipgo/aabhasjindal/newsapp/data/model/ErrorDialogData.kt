package `in`.zipgo.aabhasjindal.newsapp.data.model

class ErrorDialogData {
    var title: String? = null
    var message: String? = null
    var tokenExpired = false

    constructor(title: String?, message: String?) {
        this.title = title
        this.message = message
    }

    constructor(errors: Errors) {
        this.title = errors.title
        if (errors.messages != null && errors.messages!!.size > 0) {
            this.message = errors.messages!![0].message
        }
    }

    fun setTokenExpired(tokenExpired: Boolean): ErrorDialogData {
        this.tokenExpired = tokenExpired
        return this

    }
}