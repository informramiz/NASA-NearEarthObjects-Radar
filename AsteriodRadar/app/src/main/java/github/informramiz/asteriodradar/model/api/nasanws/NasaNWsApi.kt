package github.informramiz.asteriodradar.model.api.nasanws

import github.informramiz.asteriodradar.model.api.NasaApi.API_KEY
import github.informramiz.asteriodradar.model.api.nasanws.responses.Asteroids
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Ramiz Raja on 18/04/2020
 */
interface NasaNWsApi {
    @GET("feed")
    suspend fun getAsteroids(@Query("start_date") startDate: String? = null,
                             @Query("end_date") endDate: String? = null,
                             @Query("api_key") apiKey: String = API_KEY
    ): Response<Asteroids>
}