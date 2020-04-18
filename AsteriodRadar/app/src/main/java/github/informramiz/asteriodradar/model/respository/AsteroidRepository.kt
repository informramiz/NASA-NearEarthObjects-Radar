package github.informramiz.asteriodradar.model.respository

import github.informramiz.asteriodradar.model.api.NasaApi
import github.informramiz.asteriodradar.model.database.dao.AsteroidDao
import github.informramiz.asteriodradar.model.database.entities.toAsteroid
import github.informramiz.asteriodradar.model.respository.domain.Asteroid
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.lang.Exception
import javax.inject.Inject

/**
 * Created by Ramiz Raja on 18/04/2020
 */
class AsteroidRepository @Inject constructor(
    private val asteroidDoa: AsteroidDao,
    private val nasaApi: NasaApi
) {

    suspend fun refreshAsteroids() {
        withContext(Dispatchers.IO) {
            try {
                val response = nasaApi.getAsteroids()
                if (response.isSuccessful) {
                    Timber.d("Fetch request successful")
                } else {
                    Timber.d("Fetch request failed")
                }
            } catch (exception: Exception) {
                Timber.d(exception)
            }
        }
    }

    fun getAsteroids(): Flow<List<Asteroid>> {
        return asteroidDoa.getAsteroids().map { asteroids ->
            asteroids.map { it.toAsteroid() }
        }
    }
}