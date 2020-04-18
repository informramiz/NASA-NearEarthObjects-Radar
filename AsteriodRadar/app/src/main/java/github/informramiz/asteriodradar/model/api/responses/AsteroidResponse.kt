package github.informramiz.asteriodradar.model.api.responses

import com.squareup.moshi.Json

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