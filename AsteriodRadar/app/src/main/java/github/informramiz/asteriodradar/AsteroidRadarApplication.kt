package github.informramiz.asteriodradar

import android.app.Application
import androidx.work.WorkManager
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import github.informramiz.asteriodradar.dependencyinjection.injector.AppInjector
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Ramiz Raja on 18/04/2020
 */
class AsteroidRadarApplication: Application(), HasAndroidInjector {
    private val applicationScope = CoroutineScope(Dispatchers.Default)
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>
    override fun androidInjector() = androidInjector
    @Inject
    lateinit var workManager: WorkManager

    override fun onCreate() {
        AppInjector.init(this)
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

    fun delayInit() = applicationScope.launch {
        //initialize anything not urgent here so that application startup is not slowed down
        //by these non-urgent dependencies
        setupRecurringDataRefresh()
    }

    suspend fun setupRecurringDataRefresh() {
        //TODO()
    }
}