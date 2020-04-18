package github.informramiz.asteriodradar.view.overview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import github.informramiz.asteriodradar.databinding.ListItemAsteroidBinding
import github.informramiz.asteriodradar.model.respository.domain.Asteroid

/**
 * Created by Ramiz Raja on 19/04/2020
 */
class AsteroidItemViewHolder(private val binding: ListItemAsteroidBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(asteroid: Asteroid, clickListener: AsteroidClickListener) {
        binding.asteroid = asteroid
        binding.clickListener = clickListener
        //apply changes immediately as the view may get reused very quick
        binding.executePendingBindings()
    }
    companion object {
        fun create(parent: ViewGroup): AsteroidItemViewHolder {
            return AsteroidItemViewHolder(ListItemAsteroidBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }
}

class AsteroidClickListener(val clickListener: (asteroid: Asteroid) -> Unit) {
    fun onClick(asteroid: Asteroid) = clickListener(asteroid)
}