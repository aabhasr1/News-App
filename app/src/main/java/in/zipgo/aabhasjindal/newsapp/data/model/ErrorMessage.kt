package `in`.zipgo.aabhasjindal.newsapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ErrorMessage {
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("message")
    @Expose
    var message: String? = null
}
