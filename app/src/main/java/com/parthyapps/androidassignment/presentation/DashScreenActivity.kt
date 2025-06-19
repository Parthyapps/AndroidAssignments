package com.parthyapps.androidassignment.presentation

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.parthyapps.androidassignment.R
import com.parthyapps.androidassignment.data.model.DashboardData
import com.parthyapps.androidassignment.presentation.viewmodel.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashScreenActivity : AppCompatActivity() {

    private val viewModel: DashboardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dash_screen)
        observeUI()
    }

    private fun observeUI() {
        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect { state ->
                when (state) {
                    is DashboardUiState.Loading -> {
                        findViewById<ProgressBar>(R.id.progressBar).visibility = View.VISIBLE
                    }
                    is DashboardUiState.Success -> {
                        findViewById<ProgressBar>(R.id.progressBar).visibility = View.GONE
                        renderDashboard(state.data)
                    }
                    is DashboardUiState.Error -> {
                        findViewById<ProgressBar>(R.id.progressBar).visibility = View.GONE
                        Toast.makeText(this@DashScreenActivity, state.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    private fun renderDashboard(data: DashboardData) {
        findViewById<TextView>(R.id.profileNameTextView).text = data.profile.name
    }

}

