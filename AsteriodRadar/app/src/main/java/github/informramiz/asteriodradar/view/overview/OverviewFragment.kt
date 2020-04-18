package github.informramiz.asteriodradar.view.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import github.informramiz.asteriodradar.R
import github.informramiz.asteriodradar.view.base.BaseFragment

class OverviewFragment : BaseFragment() {
    private val viewModel: OverviewViewModel by viewModelsUsingDaggerFactory()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.overview_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}
