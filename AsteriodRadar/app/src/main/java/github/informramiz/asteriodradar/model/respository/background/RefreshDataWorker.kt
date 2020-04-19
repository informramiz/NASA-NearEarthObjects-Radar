package github.informramiz.asteriodradar.model.respository.background

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.ListenableWorker
import androidx.work.WorkerParameters
import github.informramiz.asteriodradar.dependencyinjection.modules.workermodule.SingleWorkerCreatorFactory
import github.informramiz.asteriodradar.model.respository.AsteroidRepository
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by Ramiz Raja on 19/04/2020
 */
class RefreshDataWorker(appContext: Context,
                        params: WorkerParameters,
                        private val asteroidRepository: AsteroidRepository) :
    CoroutineWorker(appContext, params) {
    companion object {
        const val WORK_NAME = "RefreshDataWork"
    }

    override suspend fun doWork(): Result {
        return try {
            asteroidRepository.refreshAsteroids()
            Timber.i("Asteroid refresh successful")
            Result.success()
        } catch (exception: Exception) {
            Timber.e("Asteroid refresh failed: $exception")
            Result.retry()
        }
    }

    /**
     * This factory is responsible for creating its enclosing worker class object by taking advantage
     * of Dagger dependency injection
     */
    class Factory@Inject constructor(private val asteroidRepository: Provider<AsteroidRepository>): SingleWorkerCreatorFactory {
        override fun create(
            context: Context,
            workerParameters: WorkerParameters
        ): ListenableWorker {
            return RefreshDataWorker(context, workerParameters, asteroidRepository.get())
        }
    }
}