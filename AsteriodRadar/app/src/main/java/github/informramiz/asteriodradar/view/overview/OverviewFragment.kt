package github.informramiz.asteriodradar.view.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import github.informramiz.asteriodradar.databinding.OverviewFragmentBinding
import github.informramiz.asteriodradar.view.base.BaseFragment
import timber.log.Timber

class OverviewFragment : BaseFragment() {
    private val viewModel: OverviewViewModel by viewModelsUsingDaggerFactory()
    private lateinit var viewBinding: OverviewFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = OverviewFragmentBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewBinding.lifecycleOwner = viewLifecycleOwner
        viewBinding.viewModel = viewModel

        viewBinding.recyclerViewAsteroids.adapter = AsteroidRecyclerAdapter(AsteroidClickListener { asteroid ->
            viewModel.onItemClick(asteroid)
        })

        viewModel.navigateToDetailEvent.observe(viewLifecycleOwner, Observer { asteroid ->
            if (asteroid != null) {
                findNavController().navigate(OverviewFragmentDirections.actionOverviewFragmentToDetailFragment())
                viewModel.onNavigationToDetailComplete()
            }
        })
    }

}
