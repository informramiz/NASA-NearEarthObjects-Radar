package github.informramiz.asteriodradar.view.overview

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import github.informramiz.asteriodradar.model.respository.domain.Asteroid

/**
 * Created by Ramiz Raja on 19/04/2020
 */
@BindingAdapter("asteroidsList")
fun RecyclerView.setAsteroidsList(asteroids: List<Asteroid>?) {
    asteroids ?: return
    (adapter as AsteroidRecyclerAdapter).submitList(asteroids)
}