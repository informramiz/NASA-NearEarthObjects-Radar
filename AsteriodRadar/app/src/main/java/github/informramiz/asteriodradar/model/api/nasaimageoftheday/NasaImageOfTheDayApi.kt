package github.informramiz.asteriodradar.model.api.nasaimageoftheday

import github.informramiz.asteriodradar.model.api.NasaApi
import github.informramiz.asteriodradar.model.api.nasaimageoftheday.resposes.ImageOfTheDayResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Ramiz Raja on 19/04/2020
 */
interface NasaImageOfTheDayApi {
    @GET("apod")
    suspend fun getImageOfTheDay(@Query("api_key") apiKey: String = NasaApi.API_KEY): Response<ImageOfTheDayResponse>
}