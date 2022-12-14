package uz.personal.cleanarchitectureandroid.data.repository

import uz.personal.cleanarchitectureandroid.data.remote.ApiInterface
import uz.personal.cleanarchitectureandroid.domain.modules.remote.DomainRemoteServerLink
import uz.personal.cleanarchitectureandroid.domain.repository.RetrofitRepository

class RetrofitRepositoryIml(private val apiInterface: ApiInterface) : RetrofitRepository {
    override suspend fun getServerDetailsUseCase(lat: Double, lot: Double): DomainRemoteServerLink {
        val serverData = apiInterface.getServerDetails(lat = lat, lot = lot)
        var response = DomainRemoteServerLink()
        if (serverData.isSuccessful) {
            val dataServer = serverData.body()
            dataServer?.let {
                if (!dataServer.error) {
                    dataServer.data.let {
                        response =
                            DomainRemoteServerLink(client_url = dataServer.data.client_url,
                                client_api_socket = dataServer.data.socket)
                    }
                }
            }
        }
        return response
    }


}