package github.informramiz.asteriodradar.view

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import github.informramiz.asteriodradar.R
import github.informramiz.asteriodradar.databinding.ActivityMainBinding
import github.informramiz.asteriodradar.view.base.BaseActivity

class MainActivity : BaseActivity() {
    private val viewBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
        setupActionBarWithNavController(findNavController(R.id.nav_host_fragment))
    }
}
