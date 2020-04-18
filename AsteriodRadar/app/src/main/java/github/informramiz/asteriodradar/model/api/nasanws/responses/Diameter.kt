package github.informramiz.asteriodradar.model.api.nasanws.responses

import com.squareup.moshi.Json

/**
 * Created by Ramiz Raja on 18/04/2020
 */
data class Diameter(
    @Json(name = "estimated_diameter_min")
    val  minEstimatedDiameter: Double,
    @Json(name = "estimated_diameter_max")
    val  maxEstimatedDiameter: Double)