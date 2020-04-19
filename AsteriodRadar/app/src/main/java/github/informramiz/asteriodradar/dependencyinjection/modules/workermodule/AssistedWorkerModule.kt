package github.informramiz.asteriodradar.dependencyinjection.modules.workermodule

import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Module

/**
 * Created by Ramiz Raja on 20/04/2020
 *
 * This module will contain all the classes (factories in our case) generated
 * by AssistedInject library and we can treat just like any other Dagger2 module. Below
 * is the way of defining it.
 */
@AssistedModule
@Module(includes = [AssistedInject_AssistedWorkerModule::class])
interface AssistedWorkerModule