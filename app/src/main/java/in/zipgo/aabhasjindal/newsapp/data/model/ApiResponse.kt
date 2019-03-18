package `in`.zipgo.aabhasjindal.newsapp.data.model

import com.google.gson.annotations.SerializedName

class ApiResponse<T> {

    @SerializedName("status_code")
    var status_code: Int = 0

    @SerializedName("errors")
    var errorBody: Errors? = null

    @SerializedName("data")
    var data: T? = null

    @SerializedName("status")
    var status: Boolean = false


}