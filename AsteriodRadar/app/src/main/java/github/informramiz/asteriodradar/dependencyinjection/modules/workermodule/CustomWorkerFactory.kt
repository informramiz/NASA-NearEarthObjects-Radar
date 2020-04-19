package github.informramiz.asteriodradar.dependencyinjection.modules.workermodule

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by Ramiz Raja on 20/04/2020
 *
 * Dagger will provide all worker factories map to this factory and this factory
 * will generate all the workers using their respective individual nested factories
 *
 * Map:
 *
 * key --> the specific worker class X that needs to be created and injected
 * value --> the factory for the worker X that knows how to generate worker X
 *
 * we have to get the factory against the worker-class X and use it to create the
 * required worker and cast to required class X before returning
 */
class CustomWorkerFactory @Inject constructor(
    private val creators: Map<
            Class<out ListenableWorker>,
            @JvmSuppressWildcards Provider<SingleWorkerCreatorFactory>
            >
) : WorkerFactory() {
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {
        val workerClass = Class.forName(workerClassName)
        //find the required worker class factory which will be stored against the value of
        //that workerClass
        val workerFactory = creators[workerClass] ?: creators.entries.firstOrNull { entry ->
            //if there is a subclass of the required worker
            entry.key.isAssignableFrom(workerClass)
        }?.value

        if (workerFactory == null) {
            throw IllegalArgumentException("Unknown worker class $workerClass")
        }

        return workerFactory.get().create(appContext, workerParameters)
    }
}