package github.informramiz.asteriodradar.view.base

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import github.informramiz.asteriodradar.dependencyinjection.injector.Injectable
import javax.inject.Inject

/**
 * Created by Ramiz Raja on 18/04/2020
 */
@SuppressLint("Registered")
open class BaseActivity: AppCompatActivity(), HasAndroidInjector {
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>
    override fun androidInjector() = androidInjector

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    inline fun <reified VM: ViewModel> viewModelsUsingDaggerFactory(): Lazy<VM> {
        return viewModels { viewModelFactory }
    }
}