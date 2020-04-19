package github.informramiz.asteriodradar.dependencyinjection.modules

import android.content.Context
import androidx.work.Configuration
import androidx.work.WorkManager
import androidx.work.WorkerFactory
import dagger.Module
import dagger.Provides
import github.informramiz.asteriodradar.dependencyinjection.modules.workermodule.CustomWorkerFactory
import github.informramiz.asteriodradar.dependencyinjection.modules.workermodule.WorkerModule
import github.informramiz.asteriodradar.model.database.AsteroidsDatabase
import github.informramiz.asteriodradar.model.database.dao.AsteroidDao
import javax.inject.Singleton

/**
 * Created by Ramiz Raja on 18/04/2020
 */
@Module(includes = [WorkerModule::class])
class AppModule {
    @Provides
    fun provideAsteroidsDatabase(context: Context): AsteroidsDatabase {
        return AsteroidsDatabase.getInstance(context)
    }

    @Provides
    fun provideAsteroidsDao(asteroidsDatabase: AsteroidsDatabase): AsteroidDao {
        return asteroidsDatabase.asteroidDao
    }

    @Singleton
    @Provides
    fun provideWorkManager(context: Context, workerFactory: WorkerFactory): WorkManager {
        WorkManager.initialize(context, Configuration.Builder().setWorkerFactory(workerFactory).build())
        return WorkManager.getInstance(context)
    }
}