package github.informramiz.asteriodradar.model.respository

import github.informramiz.asteriodradar.model.database.dao.AsteroidDao
import github.informramiz.asteriodradar.model.database.entities.toAsteroid
import github.informramiz.asteriodradar.model.respository.domain.Asteroid
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Created by Ramiz Raja on 18/04/2020
 */
class AsteroidRepository @Inject constructor(private val asteroidDoa: AsteroidDao) {

    fun getAsteroids(): Flow<List<Asteroid>> {
        return asteroidDoa.getAsteroids().map { asteroids ->
            asteroids.map { it.toAsteroid() }
        }
    }
}