package me.aprilian.coinbasesample.api

import me.aprilian.coinbasesample.data.LatestCoinResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinApiService {
    @GET("/v1/cryptocurrency/listings/latest")
    suspend fun getLate