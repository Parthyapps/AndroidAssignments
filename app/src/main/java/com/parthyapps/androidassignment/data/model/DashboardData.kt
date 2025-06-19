package com.parthyapps.androidassignment.data.model

data class DashboardData(
    val profile: Profile,
    val transactions: List<Transaction>,
    val config: Config
)