package github.informramiz.asteriodradar.view.overview

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import github.informramiz.asteriodradar.model.respository.domain.Asteroid
import github.informramiz.asteriodradar.model.respository.domain.ImageOfTheDay
import github.informramiz.asteriodradar.model.respository.utils.Response
import github.informramiz.asteriodradar.view.commonextensions.setUrl

/**
 * Created by Ramiz Raja on 19/04/2020
 */
@BindingAdapter("asteroidsList")
fun RecyclerView.setAsteroidsList(asteroids: List<Asteroid>?) {
    asteroids ?: return
    (adapter as AsteroidRecyclerAdapter).submitList(asteroids)
}

@BindingAdapter("imageOfTheDay")
fun ImageView.setImageOfTheDay(imageOfTheDayResponse: Response<ImageOfTheDay>) {
    when (imageOfTheDayResponse) {
        is Response.SuccessResponse -> {
            setUrl(imageOfTheDayResponse.data!!.url)
        }
    }
}