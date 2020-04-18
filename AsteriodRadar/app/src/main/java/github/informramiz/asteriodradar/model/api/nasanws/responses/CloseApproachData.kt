package github.informramiz.asteriodradar.model.api.nasanws.responses

import com.squareup.moshi.Json

/**
 * Created by Ramiz Raja on 18/04/2020
 */
data class CloseApproachData(
    @Json(name = "close_approach_date")
    val closeApproachDate: String,
    @Json(name = "close_approach_date_full")
    val closeApproachDateFull: String?,
    @Json(name = "epoch_date_close_approach")
    val epochDateCloseApproach: Long,
    @Json(name = "relative_velocity")
    val relativeVelocity: RelativeVelocity,
    @Json(name = "miss_distance")
    val missDistance: MissDistance,
    @Json(name = "orbiting_body")
    val orbitingBody: String
)