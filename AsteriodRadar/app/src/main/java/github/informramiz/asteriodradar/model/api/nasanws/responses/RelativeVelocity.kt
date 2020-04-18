package github.informramiz.asteriodradar.model.api.nasanws.responses

import com.squareup.moshi.Json

/**
 * Created by Ramiz Raja on 18/04/2020
 */
data class RelativeVelocity(
    @Json(name = "kilometers_per_second")
    val kmPerSecond: String,
    @Json(name = "kilometers_per_hour")
    val kmPerHour: String,
    @Json(name = "miles_per_hour")
    val milesPerHour: String
)