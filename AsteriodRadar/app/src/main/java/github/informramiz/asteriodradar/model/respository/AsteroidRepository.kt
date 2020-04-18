package github.informramiz.asteriodradar.model.respository

import github.informramiz.asteriodradar.model.api.nasaimageoftheday.NasaImageOfTheDayApi
import github.informramiz.asteriodradar.model.api.nasaimageoftheday.resposes.toImageOfTheDay
import github.informramiz.asteriodradar.model.api.nasanws.NasaNWsApi
import github.informramiz.asteriodradar.model.api.nasanws.responses.toEntityAsteroids
import github.informramiz.asteriodradar.model.database.dao.AsteroidDao
import github.informramiz.asteriodradar.model.database.entities.toAsteroid
import github.informramiz.asteriodradar.model.respository.domain.Asteroid
import github.informramiz.asteriodradar.model.respository.domain.ImageOfTheDay
import github.informramiz.asteriodradar.model.respository.utils.Response
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
    private val nasaNWsApi: NasaNWsApi,
    private val imageOfTheDayApi: NasaImageOfTheDayApi
) {

    suspend fun refreshAsteroids() {
        withContext(Dispatchers.IO) {
            try {
                val response = nasaNWsApi.getAsteroids()
                if (response.isSuccessful) {
                    Timber.d("Fetch request successful")
                    asteroidDoa.insert(*(response.body()!!.toEntityAsteroids().toTypedArray()))
                } else {
                    Timber.d("Fetch request failed")
                }
            } catch (exception: Exception) {
                Timber.d(exception)
            }
        }
    }

    suspend fun getImageOfTheDay(): Response<ImageOfTheDay> {
        return withContext(Dispatchers.IO) {
            try {
                val response = imageOfTheDayApi.getImageOfTheDay()
                Response.SuccessResponse(response.body()!!.toImageOfTheDay())
            } catch (exception: Exception) {
                Timber.d(exception)
                Response.ErrorResponse<ImageOfTheDay>(exception.localizedMessage)
            }
        }
    }

    fun getAsteroids(): Flow<List<Asteroid>> {
        return asteroidDoa.getAsteroids().map { asteroids ->
            asteroids.map { it.toAsteroid() }
        }
    }
}