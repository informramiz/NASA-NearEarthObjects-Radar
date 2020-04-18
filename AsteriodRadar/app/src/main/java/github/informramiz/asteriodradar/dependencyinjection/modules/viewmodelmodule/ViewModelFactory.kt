package github.informramiz.asteriodradar.dependencyinjection.modules.viewmodelmodule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by Ramiz Raja on 18/04/2020
 */
//the map of viewModels will be provided by Dagger
//map: key = the specific view model class, value = the specific view model class object stored as ViewModel
//we have to get the object against viewModelClass and return it by casting it to the right viewModel class
class ViewModelFactory @Inject constructor(
    private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        //dagger creator for ViewModel class T
        val creator: Provider<out ViewModel>? =
            creators[modelClass] ?: creators.entries.firstOrNull {
                it.key.isAssignableFrom(modelClass)
            }?.value

        @Suppress("UNCHECKED_CAST")
        return creator?.get() as T ?: throw IllegalArgumentException("Unknown ViewModel class $modelClass")
    }
}