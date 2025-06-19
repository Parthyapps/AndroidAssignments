package com.parthyapps.androidassignment.data.repository

import com.parthyapps.androidassignment.data.model.Config
import com.parthyapps.androidassignment.data.model.Profile
import com.parthyapps.androidassignment.data.model.Transaction

interface DashboardRepository {
    suspend fun getProfile(): Profile
    suspend fun getTransactions(profileId: String): List<Transaction>
    suspend fun getConfig(): Config
}