package github.informramiz.asteriodradar.dependencyinjection.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import github.informramiz.asteriodradar.view.MainActivity

/**
 * Created by Ramiz Raja on 18/04/2020
 */
@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun activityInjector(): MainActivity
}