package org.mtali.stock.data.remote

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface StockService {

    @GET("query?function=LISTING_STATUS")
    suspend fun getListings(@Query("api_key") apiKey: String = API_KEY): ResponseBody


    companion object {
        const val API_KEY = "M5ACZXGYW8KO92BU"
        const val BASE_URL = "https://www.alphavantage.co"
    }
}