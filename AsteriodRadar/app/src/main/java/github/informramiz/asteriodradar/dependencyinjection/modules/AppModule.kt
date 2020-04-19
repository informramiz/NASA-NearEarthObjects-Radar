package github.informramiz.asteriodradar.dependencyinjection.modules

import android.content.Context
import android.util.Log
import androidx.work.Configuration
import androidx.work.WorkManager
import androidx.work.WorkerFactory
import dagger.Module
import dagger.Provides
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
    fun provideWorkManagerConfiguration(workerFactory: WorkerFactory): Configuration {
        return Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .setMinimumLoggingLevel(Log.VERBOSE).build()
    }

    @Singleton
    @Provides
    fun provideWorkManager(context: Context, configuration: Configuration): WorkManager {
        WorkManager.initialize(context, configuration)
        return WorkManager.getInstance(context)
    }
}