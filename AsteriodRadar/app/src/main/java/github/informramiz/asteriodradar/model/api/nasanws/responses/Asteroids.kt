package github.informramiz.asteriodradar.model.api.nasanws.responses

import com.squareup.moshi.Json
import github.informramiz.asteriodradar.model.database.entities.AsteroidEntity

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

fun Asteroids.toEntityAsteroids(): List<AsteroidEntity> {
    if (elementCount == 0) {
        return emptyList()
    }

    return nearEarthObjects.values.flatten().map { it.toAsteroidEntity() }
}