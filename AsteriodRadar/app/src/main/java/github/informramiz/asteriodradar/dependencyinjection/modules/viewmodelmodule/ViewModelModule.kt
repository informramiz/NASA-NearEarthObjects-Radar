package github.informramiz.asteriodradar.dependencyinjection.modules.viewmodelmodule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import github.informramiz.asteriodradar.dependencyinjection.modules.viewmodelmodule.ViewModelFactory
import github.informramiz.asteriodradar.dependencyinjection.modules.viewmodelmodule.ViewModelKey
import github.informramiz.asteriodradar.view.overview.OverviewViewModel

/**
 * Created by Ramiz Raja on 18/04/2020
 */
@Module
interface ViewModelModule {
    //binds tells dagger which implementation to use for which interface,
    //in the case below it tells dagger to use ViewModelFactory for the interface
    // ViewModelProvider.Factory
    @Binds
    fun bindViewModelFactory(factor: ViewModelFactory): ViewModelProvider.Factory

    //because ViewModelFactory expects a map of viewModels so let's build that
    @Binds
    @IntoMap
    @ViewModelKey(OverviewViewModel::class)
    fun bind(overviewViewModel: OverviewViewModel): ViewModel
}