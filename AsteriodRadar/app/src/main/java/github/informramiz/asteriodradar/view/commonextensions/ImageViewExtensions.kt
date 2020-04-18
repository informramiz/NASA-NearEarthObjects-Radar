package github.informramiz.asteriodradar.view.commonextensions

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import github.informramiz.asteriodradar.R

/**
 * Created by Ramiz Raja on 18/04/2020
 */
@BindingAdapter("asteroidStatusImage")
fun ImageView.setAsteroidStatusImage(isHazardous: Boolean) {
    val resId = if (isHazardous) R.drawable.asteroid_hazardous else R.drawable.asteroid_safe
    setImageResource(resId)
}

@BindingAdapter("asteroidStatusIcon")
fun ImageView.setAsteroidStatusIcon(isHazardous: Boolean) {
    val resId = if (isHazardous) R.drawable.ic_status_potentially_hazardous else R.drawable.ic_status_normal
    setImageResource(resId)
}

@BindingAdapter("url")
fun ImageView.setUrl(url: String?) {
    Glide.with(this)
        .load(url ?: "")
        .placeholder(R.drawable.loading_animation)
        .error(R.drawable.ic_broken_image)
        .into(this)
}