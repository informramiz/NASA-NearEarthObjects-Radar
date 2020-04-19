package github.informramiz.asteriodradar.model.respository.background

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import github.informramiz.asteriodradar.dependencyinjection.modules.workermodule.SingleWorkerCreatorFactory
import github.informramiz.asteriodradar.model.respository.AsteroidRepository
import timber.log.Timber

/**
 * Created by Ramiz Raja on 19/04/2020
 */
class RefreshDataWorker @AssistedInject constructor(
    @Assisted
    context: Context,
    @Assisted
    params: WorkerParameters,
    private val asteroidRepository: AsteroidRepository) :
    CoroutineWorker(context, params) {
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
     * of Dagger dependency injection. AssistedInject will generate it for us by matching
     * the name of parameters and annotation @Assisted of the enclosing class constructor params
     */
    @AssistedInject.Factory
    interface Factory: SingleWorkerCreatorFactory
}