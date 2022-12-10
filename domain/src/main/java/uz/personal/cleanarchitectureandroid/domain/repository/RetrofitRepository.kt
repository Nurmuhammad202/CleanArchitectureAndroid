package uz.personal.cleanarchitectureandroid.domain.repository

interface RetrofitRepository {
    suspend fun getServerDetailsUseCase(lat: Double, lot: Double): Any
}