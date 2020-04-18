package github.informramiz.asteriodradar.view.commonextensions

import android.widget.TextView
import androidx.databinding.BindingAdapter
import github.informramiz.asteriodradar.R

/**
 * Created by Ramiz Raja on 18/04/2020
 */
@BindingAdapter("velocityText")
fun TextView.setVelocityText(velocity: Double) {
    text = context.getString(R.string.km_s_unit_format, velocity)
}

@BindingAdapter("kmUnitText")
fun TextView.setAstronomicalUnitText(value: Double) {
    text = context.getString(R.string.km_unit_format, value)
}

@BindingAdapter("astronomicalUnitText")
fun TextView.astronomicalUnitText(value: Double) {
    text = context.getString(R.string.astronomical_unit_format, value)
}