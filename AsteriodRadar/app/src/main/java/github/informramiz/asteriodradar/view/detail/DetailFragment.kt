package github.informramiz.asteriodradar.view.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import github.informramiz.asteriodradar.R
import github.informramiz.asteriodradar.databinding.DetailFragmentBinding
import github.informramiz.asteriodradar.model.domain.Asteroid
import github.informramiz.asteriodradar.view.base.BaseFragment

class DetailFragment : BaseFragment() {

    companion object {
        fun newInstance() = DetailFragment()
    }

    private val viewModel: DetailViewModel by viewModelsUsingDaggerFactory()
    private lateinit var viewBinding: DetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DetailFragmentBinding.inflate(layoutInflater, container, false)
        return viewBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewBinding.lifecycleOwner = viewLifecycleOwner
        viewBinding.asteroid = Asteroid(1, "codeName", "12-12-2020",
            0.8, 2.0, 2.0,
            2.0, true)
    }

}
