package `in`.learning.aabhasjindal.newsapp.data.database

import `in`.learning.aabhasjindal.newsapp.data.database.api.DatabaseApi
import `in`.learning.aabhasjindal.newsapp.data.model.database.Headline
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Headline::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun headlineDao(): DatabaseApi
}