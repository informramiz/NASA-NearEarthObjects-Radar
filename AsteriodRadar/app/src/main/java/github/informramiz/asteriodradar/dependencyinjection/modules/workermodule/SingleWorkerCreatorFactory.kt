package github.informramiz.asteriodradar.dependencyinjection.modules.workermodule

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerParameters

/**
 * Created by Ramiz Raja on 20/04/2020
 * This is a common interface for all individual worker factories
 */
interface SingleWorkerCreatorFactory {
    fun create(context: Context, params: WorkerParameters): ListenableWorker
}