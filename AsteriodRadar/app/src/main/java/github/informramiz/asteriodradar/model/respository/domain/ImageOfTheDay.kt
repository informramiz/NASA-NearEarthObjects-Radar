package github.informramiz.asteriodradar.model.respository.domain

/**
 * Created by Ramiz Raja on 19/04/2020
 */
enum class MediaType(val value: String) {
    IMAGE("image"),
    VIDEO("video")
}
data class ImageOfTheDay(
    val url: String,
    val hdUrl: String?,
    val mediaTypeResponse: MediaType
)