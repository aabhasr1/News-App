package `in`.zipgo.aabhasjindal.newsapp.data.network

import java.io.IOException

class ErrorCodeReturnedException(val httpStatusCode: Int) : IOException() {
    var errorCode = NO_ERROR_CODE
    var serverMessage: String? = null

    constructor(httpStatusCode: Int, errorCode: Int, serverMessage: String) : this(httpStatusCode) {
        this.errorCode = errorCode
        this.serverMessage = serverMessage
    }

    companion object {

        val NO_ERROR_CODE = -1
    }


}
