package github.informramiz.asteriodradar.dependencyinjection.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import github.informramiz.asteriodradar.model.database.AsteroidsDatabase
import github.informramiz.asteriodradar.model.database.dao.AsteroidDao

/**
 * Created by Ramiz Raja on 18/04/2020
 */
@Module
class AppModule {
    @Provides
    fun provideAsteroidsDatabase(context: Context): AsteroidsDatabase {
        return AsteroidsDatabase.getInstance(context)
    }

    @Provides
    fun provideAsteroidsDao(asteroidsDatabase: AsteroidsDatabase): AsteroidDao {
        return asteroidsDatabase.asteroidDao
    }
}