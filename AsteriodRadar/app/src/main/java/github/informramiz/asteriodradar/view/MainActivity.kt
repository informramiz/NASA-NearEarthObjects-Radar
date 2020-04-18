package github.informramiz.asteriodradar.view

import android.os.Bundle
import github.informramiz.asteriodradar.R
import github.informramiz.asteriodradar.view.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
