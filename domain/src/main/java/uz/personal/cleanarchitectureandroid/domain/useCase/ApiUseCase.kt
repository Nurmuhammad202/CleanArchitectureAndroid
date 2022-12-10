package uz.personal.cleanarchitectureandroid.domain.useCase

import uz.personal.cleanarchitectureandroid.domain.repository.RetrofitRepository

class ApiUseCase(private val retrofitRepository: RetrofitRepository) {
   suspend fun executeGetServerLink(lat: Double, lon: Double): Any {
        return retrofitRepository.getServerDetailsUseCase(lat = lat, lot = lon)
    }
}