package github.informramiz.asteriodradar.model.api.nasaimageoftheday.resposes

import com.squareup.moshi.Json
import github.informramiz.asteriodradar.model.respository.domain.ImageOfTheDay
import github.informramiz.asteriodradar.model.respository.domain.MediaType

/**
 * Created by Ramiz Raja on 19/04/2020
 */
data class ImageOfTheDayResponse(
    val url: String,
    val hdUrl: String?,
    @Json(name = "media_type")
    val mediaTypeResponse: String
)

fun ImageOfTheDayResponse.toImageOfTheDay(): ImageOfTheDay {
    val mediaType = if (mediaTypeResponse == "image") MediaType.IMAGE else MediaType.VIDEO
    return ImageOfTheDay(url, hdUrl, mediaType)
}