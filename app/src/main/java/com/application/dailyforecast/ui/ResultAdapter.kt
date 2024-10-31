package com.application.dailyforecast.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.application.dailyforecast.databinding.ItemResultBinding
import com.application.dailyforecast.utils.DateUtils.dateFormat
import com.application.dailyforecast.utils.Utils.convertFromKelvinToCelsius
import com.application.dailyforecast.utils.Utils.format2Digits
import com.application.domain.entities.CitiesModel
import com.application.domain.entities.DailyForecastData
import javax.inject.Inject


class ResultAdapter @Inject constructor() :
    ListAdapter<DailyForecastData, ResultAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, Type: Int): ViewHolder =
        ViewHolder(
            ItemResultBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemResultBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(data: DailyForecastData) {

            binding.apply {

                tvDate.text = "${data.dt_txt.dateFormat()}"
                tvTemp.text = data.main?.temp?.convertFromKelvinToCelsius().format2Digits() + " ℃"
                tvHumidity.text = "${data.main?.humidity} %"
                tvWindSpeed.text = "${data.wind?.speed} k/hr"

                if (!data.weather.isNullOrEmpty())
                    tvDescription.text = data.weather?.first()?.description

            }

            binding.root.setOnClickListener {
                onItemClickListener?.let { click ->
                    click(data)
                }
            }

            binding.executePendingBindings()
        }

    }

    class DiffCallback : DiffUtil.ItemCallback<DailyForecastData>() {
        override fun areItemsTheSame(
            oldItem: DailyForecastData, newItem: DailyForecastData
        ): Boolean = newItem == oldItem

        override fun areContentsTheSame(
            oldItem: DailyForecastData, newItem: DailyForecastData
        ): Boolean = newItem == oldItem
    }

    private var onItemClickListener: ((DailyForecastData) -> Unit)? = null

    fun setOnItemClickListener(listener: (DailyForecastData) -> Unit) {
        onItemClickListener = listener
    }

    fun submitData(data: List<DailyForecastData>?) {
        clear()
        submitList(data)
    }

    private fun clear() {
        submitList(emptyList())
    }
}