package com.parthyapps.androidassignment.data.api

import com.parthyapps.androidassignment.data.model.DashboardData
import com.parthyapps.androidassignment.data.repository.DashboardRepository
import kotlinx.coroutines.coroutineScope

class DashboardUseCase(private val repository: DashboardRepository) {
    suspend fun fetchDashboard(): DashboardData = coroutineScope {
        try {
            val profile = repository.getProfile()
            val transactions = repository.getTransactions(profile.id)
            val config = repository.getConfig()
            DashboardData(profile, transactions, config)
        } catch (e: Exception) {
            throw e
        }
    }
}
