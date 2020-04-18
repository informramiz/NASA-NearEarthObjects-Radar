package github.informramiz.asteriodradar.dependencyinjection.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import github.informramiz.asteriodradar.view.overview.OverviewFragment

/**
 * Created by Ramiz Raja on 18/04/2020
 */
@Module
interface FragmentModule {
    @ContributesAndroidInjector
    fun androidInjector(): OverviewFragment
}