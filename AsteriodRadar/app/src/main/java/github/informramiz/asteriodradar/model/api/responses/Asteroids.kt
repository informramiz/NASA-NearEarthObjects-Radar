package github.informramiz.asteriodradar.model.api.responses

import com.squareup.moshi.Json

/**
 * Created by Ramiz Raja on 18/04/2020
 */
data class Asteroids(
    val links: Links,
    @Json(name = "element_count")
    val elementCount: Int,
    @Json(name = "near_earth_objects")
    val nearEarthObjects: Map<String, List<AsteroidResponse>>
)