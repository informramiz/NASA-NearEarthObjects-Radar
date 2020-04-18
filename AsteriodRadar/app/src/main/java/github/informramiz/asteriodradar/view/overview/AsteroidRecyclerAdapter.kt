package github.informramiz.asteriodradar.view.overview

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import github.informramiz.asteriodradar.model.respository.domain.Asteroid

/**
 * Created by Ramiz Raja on 19/04/2020
 */
class AsteroidRecyclerAdapter(
    private val asteroidClickListener: AsteroidClickListener): ListAdapter<Asteroid, AsteroidItemViewHolder>(Asteroid.DIFF_ITEM_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AsteroidItemViewHolder {
        return AsteroidItemViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: AsteroidItemViewHolder, position: Int) {
        holder.bind(getItem(position), asteroidClickListener)
    }
}