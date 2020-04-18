package github.informramiz.asteriodradar.model.api

import github.informramiz.asteriodradar.model.api.responses.Asteroids
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Ramiz Raja on 18/04/2020
 */
interface NasaNWsApi {
    companion object {
        const val API_KEY = "cmPeNpKaH2oeNUfqFhfnWenrwMk6fBe3q9E09fSu"
    }
    @GET("feed")
    suspend fun getAsteroids(@Query("start_date") startDate: String? = null,
                             @Query("end_date") endDate: String? = null,
                             @Query("api_key") apiKey: String = API_KEY): Response<Asteroids>
}