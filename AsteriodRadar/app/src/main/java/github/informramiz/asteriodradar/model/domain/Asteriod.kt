package github.informramiz.asteriodradar.model.domain

import android.os.Parcelable
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