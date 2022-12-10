package uz.personal.cleanarchitectureandroid.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import uz.personal.cleanarchitectureandroid.data.remote.models.GetServerModel

interface ApiInterface {
    @GET("get/{lat}/{lon}")
    suspend fun getServerDetails(
        @Path("lat") lat: Double,
        @Path("lon") lot: Double,
    ): Response<GetServerModel>
}