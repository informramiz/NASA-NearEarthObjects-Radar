package github.informramiz.asteriodradar.dependencyinjection.modules.viewmodelmodule

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * Created by Ramiz Raja on 18/04/2020
 */
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)