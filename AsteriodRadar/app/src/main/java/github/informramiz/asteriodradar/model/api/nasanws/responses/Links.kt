package github.informramiz.asteriodradar.model.api.nasanws.responses
import com.squareup.moshi.Json

/**
 * Created by Ramiz Raja on 18/04/2020
 */
data class Links(
    @Json(name = "self")
    val current: String,
    val prev: String? = null,
    val next: String? = null)