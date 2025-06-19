📊 Sequence Diagram:

User opens DashboardActivity
        │
        ▼
DashboardViewModel.init()
        │
        ▼
launch coroutine in viewModelScope
        │
        ▼
dashboardUseCase.fetchDashboard()
        │
        ▼
repository.getProfile()
        │
        ▼
repository.getTransactions(profile.id)
        │
        ▼
repository.getConfig()
        │
        ▼
return DashboardData
        │
        ▼
emit DashboardUiState.Success(data)
        │
        ▼
UI observes and renders dashboard
