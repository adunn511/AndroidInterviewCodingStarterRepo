package com.libertymutual.android.interview.repository

import retrofit2.Response
import retrofit2.http.GET

interface EpicAPI {
    @GET("enhanced/all")
    suspend fun getAllDates(): Response<Array<Date>>
}

class EpicAPIImpl : EpicAPI {
    private val baseUrl = "https://epic.gsfc.nasa.gov/api/"
    private val serverController = ServiceController(baseUrl).createInstance()

    override suspend fun getAllDates(): Response<Array<Date>> {
        val epicApi = serverController.create(EpicAPI::class.java)
        return epicApi.getAllDates()
    }
}

data class Date(val date: String)