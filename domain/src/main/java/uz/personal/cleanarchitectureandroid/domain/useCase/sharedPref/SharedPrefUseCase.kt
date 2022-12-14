package uz.personal.cleanarchitectureandroid.domain.useCase.sharedPref

import uz.personal.cleanarchitectureandroid.domain.modules.remote.DomainRemoteServerLink
import uz.personal.cleanarchitectureandroid.domain.modules.sharedModel.ServerDetailModel
import uz.personal.cleanarchitectureandroid.domain.repository.UserRepository

class SharedPrefUseCase(private var userRepository: UserRepository) {
    fun saveServerDetails(domainRemoteServerLink: DomainRemoteServerLink): Boolean {
        return if (domainRemoteServerLink.client_api_socket != null && domainRemoteServerLink.client_url != null) {
            userRepository.saveServerDetails(
                serverUrl = domainRemoteServerLink.client_url,
                serverSocket = domainRemoteServerLink.client_api_socket)
        } else false
    }

    suspend fun getServerDetails(): ServerDetailModel {
        return userRepository.getServer()
    }
}