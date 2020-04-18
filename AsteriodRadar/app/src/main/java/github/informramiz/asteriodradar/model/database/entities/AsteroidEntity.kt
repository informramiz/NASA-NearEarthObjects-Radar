package github.informramiz.asteriodradar.model.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import github.informramiz.asteriodradar.model.respository.domain.Asteroid

/**
 * Created by Ramiz Raja on 18/04/2020
 */
@Entity(tableName = "asteroid_table")
data class AsteroidEntity(
    @PrimaryKey
    val id: Long,
    val codename: String,
    val closeApproachDate: String,
    val absoluteMagnitude: Double,
    val estimatedDiameter: Double,
    val relativeVelocity: Double,
    val distanceFromEarth: Double,
    val isPotentiallyHazardous: Boolean,
    val epochDate: Long
)

fun AsteroidEntity.toAsteroid(): Asteroid {
    return Asteroid(id, codename, closeApproachDate, absoluteMagnitude, estimatedDiameter,
        relativeVelocity, distanceFromEarth, isPotentiallyHazardous)
}