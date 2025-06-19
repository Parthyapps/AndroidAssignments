package com.parthyapps.androidassignment.data.repository

import com.parthyapps.androidassignment.data.api.DashboardApi
import com.parthyapps.androidassignment.data.model.Config
import com.parthyapps.androidassignment.data.model.Profile
import com.parthyapps.androidassignment.data.model.Transaction
import javax.inject.Inject


class DashboardRepositoryImpl @Inject constructor(
    private val api: DashboardApi
) : DashboardRepository {

    override suspend fun getProfile(): Profile = api.getProfile()

    override suspend fun getTransactions(profileId: String): List<Transaction> =
        api.getTransactions(profileId)

    override suspend fun getConfig(): Config = api.getConfig()
}