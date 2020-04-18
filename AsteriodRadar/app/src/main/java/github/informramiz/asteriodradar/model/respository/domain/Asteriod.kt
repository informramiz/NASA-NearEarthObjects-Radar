package github.informramiz.asteriodradar.model.respository.domain

import android.os.Parcelable
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
                    val isPotentiallyHazardous: Boolean) : Parcelable

fun Asteroid.toAsteroidEntity(): AsteroidEntity {
    return AsteroidEntity(id, codename, closeApproachDate, absoluteMagnitude, estimatedDiameter, relativeVelocity, distanceFromEarth, isPotentiallyHazardous, System.currentTimeMillis())
}