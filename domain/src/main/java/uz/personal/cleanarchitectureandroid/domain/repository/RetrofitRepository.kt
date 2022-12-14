package uz.personal.cleanarchitectureandroid.domain.repository

import uz.personal.cleanarchitectureandroid.domain.modules.remote.DomainRemoteServerLink

interface RetrofitRepository {
    suspend fun getServerDetailsUseCase(lat: Double, lot: Double): DomainRemoteServerLink
}