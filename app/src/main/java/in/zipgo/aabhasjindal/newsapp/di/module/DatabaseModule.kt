package `in`.zipgo.aabhasjindal.newsapp.di.module

import `in`.zipgo.aabhasjindal.newsapp.data.database.AppDatabase
import `in`.zipgo.aabhasjindal.newsapp.di.scope.AppScope
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {
    @AppScope
    @Provides
    fun getDatabase(context: Context) =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java, "news-database"
        ).build()
}