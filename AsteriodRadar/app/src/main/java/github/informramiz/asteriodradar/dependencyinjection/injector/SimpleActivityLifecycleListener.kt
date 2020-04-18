package github.informramiz.asteriodradar.dependencyinjection.injector

import android.app.Activity
import android.app.Application
import android.os.Bundle

/**
 * Created by Ramiz Raja on 18/04/2020
 */
open class SimpleActivityLifecycleListener: Application.ActivityLifecycleCallbacks {
    override fun onActivityPaused(activity: Activity) {}

    override fun onActivityStarted(activity: Activity) {}

    override fun onActivityDestroyed(activity: Activity) {}

    override fun onActivitySaveInstanceState(activity: Activity, bundle: Bundle) {}

    override fun onActivityStopped(activity: Activity) {}

    override fun onActivityCreated(activity: Activity, bundle: Bundle?) {}

    override fun onActivityResumed(activity: Activity) {}
}