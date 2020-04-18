package github.informramiz.asteriodradar

import android.app.Application
import github.informramiz.asteriodradar.dependencyinjection.components.AppComponent
import github.informramiz.asteriodradar.dependencyinjection.components.DaggerAppComponent
import timber.log.Timber

/**
 * Created by Ramiz Raja on 18/04/2020
 */
class AsteroidRadarApplication: Application() {
    // Instance of the AppComponent that will be used by all the Activities in the project
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}