package github.informramiz.asteriodradar.dependencyinjection.modules.workermodule

import androidx.work.ListenableWorker
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * Created by Ramiz Raja on 20/04/2020
 */
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class WorkerKey(val value: KClass<out ListenableWorker>)