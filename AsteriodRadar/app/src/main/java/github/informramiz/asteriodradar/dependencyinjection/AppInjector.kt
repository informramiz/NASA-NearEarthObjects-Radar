package github.informramiz.asteriodradar.dependencyinjection

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import github.informramiz.asteriodradar.AsteroidRadarApplication
import github.informramiz.asteriodradar.dependencyinjection.components.DaggerAppComponent
import github.informramiz.asteriodradar.dependencyinjection.injector.SimpleActivityLifecycleListener

object AppInjector {
    fun init(application: AsteroidRadarApplication) {
        DaggerAppComponent.factory().create(application.applicationContext)
            .inject(application)

        application.registerActivityLifecycleCallbacks(object: SimpleActivityLifecycleListener() {
            override fun onActivityCreated(activity: Activity, bundle: Bundle?) {
                AndroidInjection.inject(activity)
                handleFragmentInjection(activity)
                super.onActivityCreated(activity, bundle)
            }
        })
    }

    private fun handleFragmentInjection(activity: Activity) {
        if (activity !is AppCompatActivity) return

        activity.supportFragmentManager.registerFragmentLifecycleCallbacks(object : FragmentManager.FragmentLifecycleCallbacks() {
            override fun onFragmentAttached(fm: FragmentManager, f: Fragment, context: Context) {
                AndroidSupportInjection.inject(f)
                super.onFragmentAttached(fm, f, context)
            }
        }, true)
    }
}