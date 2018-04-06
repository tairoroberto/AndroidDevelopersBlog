package br.com.trmamobilesolutions.androiddevelopersblog.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import br.com.trmamobilesolutions.androiddevelopersblog.data.dao.PostsDao
import com.remoteok.io.app.model.Company
import com.remoteok.io.app.model.HighestPaid
import com.remoteok.io.app.model.Job


@Database(entities = [(Job::class), (Company::class), (HighestPaid::class)], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun jobsDAO(): PostsDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context?): AppDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: buildDatabase(context as Context).also { INSTANCE = it }
                }


        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        AppDatabase::class.java, "androiddevelopersblog.db")
                        .fallbackToDestructiveMigration()
                        .build()
    }
}
