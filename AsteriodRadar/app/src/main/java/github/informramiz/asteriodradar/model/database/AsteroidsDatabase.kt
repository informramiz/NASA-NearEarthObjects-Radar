package github.informramiz.asteriodradar.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import github.informramiz.asteriodradar.model.database.dao.AsteroidDao
import github.informramiz.asteriodradar.model.database.entities.AsteroidEntity
import javax.inject.Singleton

/**
 * Created by Ramiz Raja on 18/04/2020
 */
@Singleton
@Database(entities = [AsteroidEntity::class], version = 1, exportSchema = true)
abstract class AsteroidsDatabase protected constructor(): RoomDatabase() {
    abstract val asteroidDao: AsteroidDao
    companion object {
        @Volatile
        private lateinit var INSTANCE: AsteroidsDatabase
        fun getInstance(context: Context): AsteroidsDatabase {
            synchronized(this) {
                if (!this::INSTANCE.isInitialized) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, AsteroidsDatabase::class.java, "asteroidsDatabase")
                        .fallbackToDestructiveMigration()
                        .build()
                }
                return INSTANCE
            }
        }
    }
}