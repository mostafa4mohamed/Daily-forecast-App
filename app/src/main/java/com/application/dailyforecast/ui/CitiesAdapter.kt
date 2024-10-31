package com.application.dailyforecast.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.application.dailyforecast.databinding.ItemCityBinding
import com.application.domain.entities.CitiesModel.*
import java.util.Locale


class CitiesAdapter(activity: Activity) :
    ArrayAdapter<City?>(activity, 0, emptyList<City>() as List<City?>) {

    private var items = ArrayList<City>()

    override fun getCount(): Int = items.size

    override fun getItem(position: Int): City = items[position]

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val binding = ItemCityBinding.inflate(LayoutInflater.from(parent.context))

        val holder = ViewHolder(binding)
        holder.bind(items[position])

        return binding.root

    }

    inner class ViewHolder(private val binding: ItemCityBinding) {

        @SuppressLint("SetTextI18n")
        fun bind(data: City) {

            binding.apply {

                val locale = Locale.getDefault()

                val cityName=if (locale.language.equals("en",true))
                    data.cityNameEn
                else
                    data.cityNameAr

                countryTxt.text = cityName

                executePendingBindings()
            }

        }

    }

    fun submitList(items: ArrayList<City>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun clear() {
        clearList()
    }

    private fun clearList() {
        this.items = ArrayList()
        notifyDataSetChanged()
    }

    fun onItemSelected(textView: TextView, position: Int): City {

        val data = items[position]

        val locale = Locale.getDefault()

        val cityName=if (locale.language.equals("en",true))
            data.cityNameEn
        else
            data.cityNameAr

        textView.text = cityName
        return data
    }

}