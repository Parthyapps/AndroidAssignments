# 📊 Sequence Diagram

```mermaid
sequenceDiagram
    participant UI as DashboardActivity
    participant VM as DashboardViewModel
    participant UC as DashboardUseCase
    participant Repo as DashboardRepository
    participant API as DashboardApi

    UI->>VM: onCreate()
    VM->>VM: init -> loadDashboard()
    VM->>UC: fetchDashboard()
    UC->>Repo: getProfile()
    Repo->>API: getProfile()
    API-->>Repo: Profile
    Repo-->>UC: Profile

    UC->>Repo: getTransactions(profile.id)
    Repo->>API: getTransactions(profileId)
    API-->>Repo: List<Transaction>
    Repo-->>UC: List<Transaction>

    UC->>Repo: getConfig()
    Repo->>API: getConfig()
    API-->>Repo: Config
    Repo-->>UC: Config

    UC-->>VM: DashboardData(Profile, Transactions, Config)
    VM-->>UI: emit Success state (DashboardUiState.Success)
    UI->>UI: Render Dashboard
