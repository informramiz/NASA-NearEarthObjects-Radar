package github.informramiz.asteriodradar.view.base

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import github.informramiz.asteriodradar.AsteroidRadarApplication

/**
 * Created by Ramiz Raja on 18/04/2020
 */
@SuppressLint("Registered")
open class BaseActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        (application as AsteroidRadarApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }
}