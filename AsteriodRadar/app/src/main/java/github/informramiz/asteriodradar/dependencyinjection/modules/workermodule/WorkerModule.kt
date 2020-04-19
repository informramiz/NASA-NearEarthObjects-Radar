package github.informramiz.asteriodradar.dependencyinjection.modules.workermodule

import androidx.work.WorkerFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import github.informramiz.asteriodradar.model.respository.background.RefreshDataWorker
import javax.inject.Singleton

/**
 * Created by Ramiz Raja on 20/04/2020
 *
 * Module to contain dependencies for all workers
 */
@Module(includes = [AssistedWorkerModule::class])
interface WorkerModule {
    @Singleton
    @Binds
    fun provideWorkerFactory(customWorkerFactory: CustomWorkerFactory): WorkerFactory

    @Binds
    @IntoMap
    @WorkerKey(RefreshDataWorker::class)
    fun provideRefreshDataWorkerFactory(refreshDataWorkerFactory: RefreshDataWorker.Factory): SingleWorkerCreatorFactory
}