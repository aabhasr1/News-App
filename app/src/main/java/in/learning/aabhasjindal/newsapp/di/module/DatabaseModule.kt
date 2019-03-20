package `in`.learning.aabhasjindal.newsapp.di.module

import `in`.learning.aabhasjindal.newsapp.data.database.AppDatabase
import `in`.learning.aabhasjindal.newsapp.di.scope.AppScope
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
        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()

    @AppScope
    @Provides
    fun getNewsApi(database: AppDatabase) = database.headlineDao()
}