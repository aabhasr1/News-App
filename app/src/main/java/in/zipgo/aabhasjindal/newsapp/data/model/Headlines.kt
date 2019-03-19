package `in`.zipgo.aabhasjindal.newsapp.data.model

import `in`.zipgo.aabhasjindal.newsapp.data.model.database.Headline
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Headlines : BaseApiResponse() {

    @Expose
    @SerializedName("articles")
    var articles: ArrayList<Headline>? = null

    @Expose
    @SerializedName("totalResults")
    var totalResults: Int? = 0

    class Headline {

        @Expose
        @SerializedName("source")
        var source: Source? = null

        @Expose
        @SerializedName("author")
        var author: String? = null

        @Expose
        @SerializedName("title")
        var title: String? = null

        @Expose
        @SerializedName("description")
        var description: String? = null

        @Expose
        @SerializedName("url")
        var url: String? = null

        @Expose
        @SerializedName("urlToImage")
        var urlToImage: String? = null

        @Expose
        @SerializedName("publishedAt")
        var publishedAt: String? = null

        @Expose
        @SerializedName("content")
        var content: String? = null
    }

    class Source {

        @Expose
        @SerializedName("id")
        var id: String? = null

        @Expose
        @SerializedName("name")
        var name: String? = null
    }

    fun toHeadLinesList(): ArrayList<`in`.zipgo.aabhasjindal.newsapp.data.model.database.Headline> {
        val headLineDataList = ArrayList<`in`.zipgo.aabhasjindal.newsapp.data.model.database.Headline>()
        articles!!.forEach {
            headLineDataList.add(
                Headline(
                    null
                    , it.source?.id, it.source?.name, it.author, it.title, it.description
                    , it.url, it.urlToImage, it.publishedAt, it.content
                )
            )
        }
        return headLineDataList
    }
}