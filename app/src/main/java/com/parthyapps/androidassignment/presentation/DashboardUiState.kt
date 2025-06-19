package com.parthyapps.androidassignment.presentation

import com.parthyapps.androidassignment.data.model.DashboardData

sealed class DashboardUiState {
    object Loading : DashboardUiState()
    data class Success(val data: DashboardData) : DashboardUiState()
    data class Error(val message: String) : DashboardUiState()
}