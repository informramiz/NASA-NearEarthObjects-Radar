package github.informramiz.asteriodradar.model.respository.domain

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import github.informramiz.asteriodradar.model.database.entities.AsteroidEntity
import kotlinx.android.parcel.Parcelize

/**
 * Created by Ramiz Raja on 18/04/2020
 */
@Parcelize
data class Asteroid(val id: Long,
                    val codename: String,
                    val closeApproachDate: String,
                    val absoluteMagnitude: Double,
                    val estimatedDiameter: Double,
                    val relativeVelocity: Double,
                    val distanceFromEarth: Double,
                    val isPotentiallyHazardous: Boolean) : Parcelable {
    companion object {
        val DIFF_ITEM_CALLBACK = object : DiffUtil.ItemCallback<Asteroid>() {
            override fun areItemsTheSame(oldItem: Asteroid, newItem: Asteroid): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Asteroid, newItem: Asteroid): Boolean {
                return oldItem == newItem
            }

        }
    }
}

fun Asteroid.toAsteroidEntity(): AsteroidEntity {
    return AsteroidEntity(id, codename, closeApproachDate, absoluteMagnitude, estimatedDiameter, relativeVelocity, distanceFromEarth, isPotentiallyHazardous, System.currentTimeMillis())
}