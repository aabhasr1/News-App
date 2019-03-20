package `in`.learning.aabhasjindal.newsapp.data.database.api

import `in`.learning.aabhasjindal.newsapp.data.model.database.Headline
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Single

@Dao
interface DatabaseApi {
    @Query("SELECT * FROM headlines")
    fun getAllHeadlines(): Single<MutableList<Headline>>

    @Insert
    fun insertAllHeadLines(headlines: ArrayList<Headline>)

    @Delete
    fun deleteHeadline(headlines: ArrayList<Headline>)

    @Query("DELETE FROM headlines")
    fun nukeTable()
}