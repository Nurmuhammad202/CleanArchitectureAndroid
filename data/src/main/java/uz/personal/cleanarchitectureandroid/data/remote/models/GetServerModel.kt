package uz.personal.cleanarchitectureandroid.data.remote.models

data class GetServerModel(
    val `data`: Data,
    val error: Boolean,
    val message: String,
)