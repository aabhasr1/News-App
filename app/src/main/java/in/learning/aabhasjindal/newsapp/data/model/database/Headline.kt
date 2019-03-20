package `in`.learning.aabhasjindal.newsapp.data.model.database

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "headlines")
class Headline(

    @PrimaryKey
    var newsId: Int? = null,

    @ColumnInfo(name = "source_id")
    var sourceId: String? = null,

    @ColumnInfo(name = "source_name")
    var sourceName: String? = null,

    @ColumnInfo(name = "author")
    var author: String? = null,

    @ColumnInfo(name = "title")
    var title: String? = null,

    @ColumnInfo(name = "description")
    var description: String? = null,

    @ColumnInfo(name = "url")
    var url: String? = null,

    @ColumnInfo(name = "url_to_image")
    var urlToImage: String? = null,

    @ColumnInfo(name = "published_at")
    var publishedAt: String? = null,

    @ColumnInfo(name = "content")
    var content: String? = null
) : Parcelable {

    @Ignore
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        if (parcel.readInt() == 1) {
            parcel.readString()
        } else null,
        if (parcel.readInt() == 1) {
            parcel.readString()
        } else null,
        if (parcel.readInt() == 1) {
            parcel.readString()
        } else null,
        if (parcel.readInt() == 1) {
            parcel.readString()
        } else null,
        if (parcel.readInt() == 1) {
            parcel.readString()
        } else null,
        if (parcel.readInt() == 1) {
            parcel.readString()
        } else null,
        if (parcel.readInt() == 1) {
            parcel.readString()
        } else null,
        if (parcel.readInt() == 1) {
            parcel.readString()
        } else null,
        if (parcel.readInt() == 1) {
            parcel.readString()
        } else null
    )

    override fun writeToParcel(dest: Parcel, flags: Int) {
        if (newsId != null) {
            dest.writeInt(1)
        } else {
            dest.writeInt(0)
        }
        if (sourceId != null) {
            dest.writeInt(1)
            dest.writeString(sourceId!!)
        } else {
            dest.writeInt(0)
        }
        if (sourceName != null) {
            dest.writeInt(1)
            dest.writeString(sourceName!!)
        } else {
            dest.writeInt(0)
        }
        if (author != null) {
            dest.writeInt(1)
            dest.writeString(author!!)
        } else {
            dest.writeInt(0)
        }
        if (title != null) {
            dest.writeInt(1)
            dest.writeString(title!!)
        } else {
            dest.writeInt(0)
        }
        if (description != null) {
            dest.writeInt(1)
            dest.writeString(description!!)
        } else {
            dest.writeInt(0)
        }
        if (url != null) {
            dest.writeInt(1)
            dest.writeString(url!!)
        } else {
            dest.writeInt(0)
        }
        if (urlToImage != null) {
            dest.writeInt(1)
            dest.writeString(urlToImage!!)
        } else {
            dest.writeInt(0)
        }
        if (publishedAt != null) {
            dest.writeInt(1)
            dest.writeString(publishedAt!!)
        } else {
            dest.writeInt(0)
        }
        if (content != null) {
            dest.writeInt(1)
            dest.writeString(content!!)
        } else {
            dest.writeInt(0)
        }
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<Headline> {
        override fun createFromParcel(parcel: Parcel): Headline {
            return Headline(parcel)
        }

        override fun newArray(size: Int): Array<Headline?> {
            return arrayOfNulls(size)
        }
    }
}