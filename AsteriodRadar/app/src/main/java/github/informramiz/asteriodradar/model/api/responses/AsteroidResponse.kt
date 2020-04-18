package github.informramiz.asteriodradar.model.api.responses

import com.squareup.moshi.Json
import github.informramiz.asteriodradar.model.database.entities.AsteroidEntity

/**
 * Created by Ramiz Raja on 18/04/2020
 */
data class AsteroidResponse(
    val id: String,
    val name: String,
    @Json(name = "neo_reference_id")
    val neoReferenceId: String,
    @Json(name = "nasa_jpl_url")
    val nasaJPLUrl: String,
    @Json(name = "absolute_magnitude_h")
    val absoluteMagnitude: Double,
    @Json(name = "estimated_diameter")
    val estimatedDiameter: EstimatedDiameter,
    @Json(name = "is_potentially_hazardous_asteroid")
    val isPotentiallyHazardousAsteroid: Boolean,
    @Json(name = "close_approach_data")
    val closeApproachData: List<CloseApproachData> = emptyList()
)

fun AsteroidResponse.toAsteroidEntity(): AsteroidEntity {
//    val id: Long,
//    val codename: String,
//    val closeApproachDate: String,
//    val absoluteMagnitude: Double,
//    val estimatedDiameter: Double,
//    val relativeVelocity: Double,
//    val distanceFromEarth: Double,
//    val isPotentiallyHazardous: Boolean,
//    val epochDate: Long
    val distanceFromEarth = closeApproachData.first().missDistance.astronomical.toDouble()
    val epochDate = closeApproachData.first().epochDateCloseApproach
    val closeApproachDate = closeApproachData.first().closeApproachDate
    val estimatedDiameterDouble = estimatedDiameter.kilometers.maxEstimatedDiameter
    val relativeVelocity = closeApproachData.first().relativeVelocity.kmPerSecond.toDouble()
    return AsteroidEntity(id.toLong(), name, closeApproachDate, absoluteMagnitude,
        estimatedDiameterDouble, relativeVelocity, distanceFromEarth,
        isPotentiallyHazardousAsteroid, epochDate)
}