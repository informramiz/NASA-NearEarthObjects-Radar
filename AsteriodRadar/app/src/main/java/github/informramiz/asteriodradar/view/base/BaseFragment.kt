package github.informramiz.asteriodradar.view.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import github.informramiz.asteriodradar.dependencyinjection.injector.Injectable
import javax.inject.Inject

/**
 * Created by Ramiz Raja on 18/04/2020
 */
open class BaseFragment: Fragment(), HasAndroidInjector, Injectable {
    lateinit var androidInjector: DispatchingAndroidInjector<Any>
    override fun androidInjector() = androidInjector

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    inline fun <reified VM: ViewModel> viewModelsUsingDaggerFactory(): Lazy<VM> {
        return viewModels { viewModelFactory }
    }

    inline fun <reified VM: ViewModel> activityViewModelsUsingDaggerFactory(): Lazy<VM> {
        return activityViewModels { viewModelFactory }
    }
}