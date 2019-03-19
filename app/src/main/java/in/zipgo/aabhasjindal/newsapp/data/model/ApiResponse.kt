package `in`.zipgo.aabhasjindal.newsapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open class BaseApiResponse {
    companion object {
        val STATUS_OK = "ok"
        val STATUS_ERROR = "error"
    }

    @SerializedName("status_code")
    @Expose
    var status_code: Int = 0

    @SerializedName("code")
    @Expose
    var errorCode: String? = null

    @SerializedName("message")
    @Expose
    var errorBody: String? = null

    @SerializedName("status")
    @Expose
    var status: String? = null
}