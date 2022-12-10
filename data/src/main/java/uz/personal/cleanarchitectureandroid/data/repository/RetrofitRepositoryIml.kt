package uz.personal.cleanarchitectureandroid.data.repository

import uz.personal.cleanarchitectureandroid.data.remote.ApiInterface
import uz.personal.cleanarchitectureandroid.domain.repository.RetrofitRepository

class RetrofitRepositoryIml(private val apiInterface: ApiInterface) : RetrofitRepository {
    override suspend fun getServerDetailsUseCase(lat: Double, lot: Double): Any {
        val serverData = apiInterface.getServerDetails(lat = lat, lot = lot)
        if (serverData.isSuccessful) {
            val response = serverData.body()
            response?.let { it ->
                return it
            }
        }
        return "not data!!"
    }


}