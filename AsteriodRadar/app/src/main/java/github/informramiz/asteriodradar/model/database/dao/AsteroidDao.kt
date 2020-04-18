package github.informramiz.asteriodradar.model.database.dao

import androidx.room.*
import github.informramiz.asteriodradar.model.database.entities.AsteroidEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by Ramiz Raja on 18/04/2020
 */
@Dao
abstract class AsteroidDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(vararg asteroids: AsteroidEntity)

    @Query("SELECT * FROM asteroid_table WHERE epochDate >= :currentTime")
    abstract fun getAsteroids(currentTime: Long = System.currentTimeMillis()): Flow<List<AsteroidEntity>>

    @Transaction
    @Query("DELETE FROM asteroid_table")
    abstract suspend fun clear()
}