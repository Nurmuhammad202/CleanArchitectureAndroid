package uz.personal.cleanarchitectureandroid.data.remote.models

data class Data(
    val client_url: String,
    val latitude: Double,
    val longitude: Double,
    val name: String,
    val socket: String,
    val url: String,
    val client_api_socket: String,
)