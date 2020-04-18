package github.informramiz.asteriodradar

import android.app.Application
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import github.informramiz.asteriodradar.dependencyinjection.AppInjector
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Ramiz Raja on 18/04/2020
 */
class AsteroidRadarApplication: Application(), HasAndroidInjector {
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>
    override fun androidInjector() = androidInjector

    override fun onCreate() {
        AppInjector.init(this)
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}