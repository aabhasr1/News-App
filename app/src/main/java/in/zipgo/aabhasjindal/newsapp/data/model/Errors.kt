package `in`.zipgo.aabhasjindal.newsapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Errors {
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("messages")
    @Expose
    var messages: List<ErrorMessage>? = null
}
