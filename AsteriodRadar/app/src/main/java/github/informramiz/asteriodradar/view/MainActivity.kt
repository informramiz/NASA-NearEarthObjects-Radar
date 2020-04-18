package github.informramiz.asteriodradar.view

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import github.informramiz.asteriodradar.AsteroidRadarApplication
import github.informramiz.asteriodradar.R
import github.informramiz.asteriodradar.view.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity() {
    @Inject
    lateinit var myContext: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(myContext, "This is injected applicatoin context!", Toast.LENGTH_SHORT).show()
    }
}
