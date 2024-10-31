package com.application.dailyforecast.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.application.dailyforecast.R
import com.application.dailyforecast.databinding.ActivityMainBinding
import com.application.dailyforecast.utils.Constants
import com.application.dailyforecast.utils.NetworkState
import com.application.domain.entities.CitiesModel
import com.application.domain.entities.DailyForecastData
import com.application.domain.entities.DailyForecastResponse
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private var selectedCity: CitiesModel.City? = null

    @Inject
    lateinit var resultAdapter: ResultAdapter

    private lateinit var citiesAdapter: CitiesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        prepareViews()
        observeAtStateFlows()
        getLocalCities()

    }

    private fun getLocalCities() {
        viewModel.getLocalCities()
    }

    private fun prepareViews() {

        binding.apply {

            citiesAdapter = CitiesAdapter(this@MainActivity)

            result.rvResults.adapter = resultAdapter
            toolBar.citiesMenu.setAdapter(citiesAdapter)

            error.retry.setOnClickListener { getDailyForecast() }

            toolBar.citiesMenu.setOnItemClickListener { _, _, position, _ ->
                onCitySelected(position)
            }

//            toolBar.search.setOnClickListener { verify() }

        }
    }

    private fun onCitySelected(position: Int) {

        citiesAdapter.onItemSelected(binding.toolBar.citiesMenu, position)
        val newCity = citiesAdapter.getItem(position)

        if (selectedCity == null || newCity.id != selectedCity?.id) {
            selectedCity = newCity
            getDailyForecast()
        }

    }

    private fun getDailyForecast() {

        viewModel.getDailyForecastByCity(
            selectedCity?.id ?: 0,
            selectedCity?.lat ?: 0.0,
            selectedCity?.lon ?: 0.0
        )

    }


    private fun observeAtStateFlows() {

        lifecycleScope.launch {
            viewModel.getDailyForecastStateFlow.collect {
                when (it) {
                    is NetworkState.Idle -> {
                        visIdleView()
                    }

                    is NetworkState.Loading -> {
                        visLoadingView()
                    }

                    is NetworkState.Error -> {
                        visErrorView(it.msg)
                    }

                    is NetworkState.Result<DailyForecastResponse?> -> {
                        handleResult(it.response!!, it.onlineState)
                    }
                }
            }
        }

        lifecycleScope.launch {
            viewModel.getCitiesStateFlow.collect {
                when (it) {
                    is NetworkState.Result<CitiesModel> -> {
                        fullDropDownMenu(it.response)
                    }

                    else -> Unit
                }
            }
        }

    }

    private fun fullDropDownMenu(citiesModel: CitiesModel) {
        citiesAdapter.submitList(citiesModel.cities as ArrayList<CitiesModel.City>)
    }

    private fun handleResult(response: DailyForecastResponse, online: Boolean?) {

        visResultView()

        when {
            response.list.isNullOrEmpty() -> visErrorView(getString(R.string.empty_data))
            response.cod!! == Constants.Codes.SUCCESSES_CODE.toString() -> {
                ui(response.list, online ?: false)
            }
        }
    }

    private fun ui(data: List<DailyForecastData>?, isOnline: Boolean) {

        binding.result.offline.isVisible = !isOnline
        resultAdapter.submitData(data)

    }

    private fun visResultView() {


        binding.apply {
            View.GONE.also { vis ->
                idle.root.visibility = vis
                error.root.visibility = vis
                loading.root.visibility = vis
            }

            result.root.visibility = View.VISIBLE
        }

    }

    private fun visLoadingView() {


        binding.apply {
            View.GONE.also { vis ->
                idle.root.visibility = vis
                error.root.visibility = vis
                result.root.visibility = vis
            }

            loading.root.visibility = View.VISIBLE
        }

    }

    private fun visIdleView() {

        binding.apply {
            idle.root.visibility = View.VISIBLE
            View.GONE.also { vis ->
                result.root.visibility = vis
                error.root.visibility = vis
                loading.root.visibility = vis
            }
        }

    }

    private fun visErrorView(message: String?) {

        binding.apply {

            View.GONE.also { vis ->
                idle.root.visibility = vis
                result.root.visibility = vis
                loading.root.visibility = vis
            }

            error.apply {
                root.visibility = View.VISIBLE

                sorry.apply {
                    if (message.isNullOrEmpty())
                        visibility = View.GONE
                    else {
                        visibility = View.VISIBLE
                        text = message
                    }
                }
            }

        }


    }

}