package `in`.zipgo.aabhasjindal.newsapp.data.database.api

import `in`.zipgo.aabhasjindal.newsapp.data.model.database.Headline
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NewsApi {
    @Query("SELECT * FROM headlines")
    fun getAll(): List<Headline>

    @Insert
    fun insertAll(headlines: ArrayList<Headline>)

    @Delete
    fun delete(headlines: ArrayList<Headline>)
}