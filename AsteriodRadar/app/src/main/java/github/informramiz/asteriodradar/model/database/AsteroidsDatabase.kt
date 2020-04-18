package github.informramiz.asteriodradar.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import github.informramiz.asteriodradar.model.database.dao.AsteroidDao
import github.informramiz.asteriodradar.model.database.entities.AsteroidEntity

/**
 * Created by Ramiz Raja on 18/04/2020
 */
@Database(entities = [AsteroidEntity::class], version = 1, exportSchema = true)
abstract class AsteroidsDatabase: RoomDatabase() {
    abstract val asteroidDao: AsteroidDao
    companion object {
        private lateinit var INSTANCE: AsteroidsDatabase
        fun getInstance(context: Context): AsteroidsDatabase {
            if (!this::INSTANCE.isInitialized) {
                INSTANCE = Room.databaseBuilder(context.applicationContext, AsteroidsDatabase::class.java, "asteroidsDatabase")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return INSTANCE
        }
    }
}