package uz.personal.cleanarchitectureandroid.domain.useCase.remote

import uz.personal.cleanarchitectureandroid.domain.modules.remote.DomainRemoteServerLink
import uz.personal.cleanarchitectureandroid.domain.repository.RetrofitRepository

class ApiUseCase(
    private val retrofitRepository: RetrofitRepository,
) {
    suspend fun executeGetServerLink(lat: Double, lon: Double): DomainRemoteServerLink {
        return retrofitRepository.getServerDetailsUseCase(lat = lat, lot = lon)
    }

}