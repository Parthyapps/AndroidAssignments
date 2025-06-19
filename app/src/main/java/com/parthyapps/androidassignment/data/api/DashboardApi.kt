package com.parthyapps.androidassignment.data.api

import android.provider.ContactsContract
import com.parthyapps.androidassignment.data.model.Config
import com.parthyapps.androidassignment.data.model.Profile
import com.parthyapps.androidassignment.data.model.Transaction
import retrofit2.http.GET
import retrofit2.http.Query

interface DashboardApi {
    @GET("profile")
    suspend fun getProfile(): Profile

    @GET("transactions")
    suspend fun getTransactions(@Query("profileId") profileId: String): List<Transaction>

    @GET("config")
    suspend fun getConfig(): Config
}
