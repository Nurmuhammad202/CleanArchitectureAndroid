package uz.personal.cleanarchitectureandroid.domain.useCase

import uz.personal.cleanarchitectureandroid.domain.modules.remote.DomainRemoteServerLink
import uz.personal.cleanarchitectureandroid.domain.repository.RetrofitRepository
import uz.personal.cleanarchitectureandroid.domain.repository.UserRepository

class ApiUseCase(
    private val retrofitRepository: RetrofitRepository,
    private var userRepository: UserRepository,
) {
    suspend fun executeGetServerLink(lat: Double, lon: Double): Boolean {
        val response = retrofitRepository.getServerDetailsUseCase(lat = lat, lot = lon)
        response.let {
            if (it.client_api_socket != null && it.client_url != null) {
                return saveServerDetails(it.client_url, it.client_api_socket)
            }
        }
        return false
    }

    private fun saveServerDetails(serverUrl: String, serverSocket: String): Boolean {
        return userRepository.saveServerDetails(serverUrl = serverUrl, serverSocket = serverSocket)
    }
}