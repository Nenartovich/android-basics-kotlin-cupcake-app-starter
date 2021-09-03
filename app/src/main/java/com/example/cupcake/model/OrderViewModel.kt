package com.example.cupcake.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

class OrderViewModel : ViewModel() {
    private val _quantity: MutableLiveData<Int> = MutableLiveData()
    val quantity: LiveData<Int> get() = _quantity

    private val _flavour: MutableLiveData<String> = MutableLiveData()
    val flavour: LiveData<String> get() = _flavour

    private val _date: MutableLiveData<String> = MutableLiveData()
    val date: LiveData<String> get() = _date

    private val _price: MutableLiveData<Double> = MutableLiveData()
    val price: LiveData<Double> get() = _price

    val dateOptions = getPickupOptions()


    init {
        resetOrder()
    }

    fun setQuantity(numberCupcakes: Int) {
        _quantity.value = numberCupcakes
    }

    fun setFlavour(desiredFlavour: String) {
        _flavour.value = desiredFlavour
    }

    fun setDate(pickupDate: String) {
        _date.value = pickupDate
    }

    fun hasNoFlavour() = _flavour.value.isNullOrEmpty()

    private fun getPickupOptions(): List<String> {
        val options = mutableListOf<String>()
        val formatter = SimpleDateFormat("EEE, MMM d", Locale.US)
        val calendar = Calendar.getInstance()
        repeat(4) {
            options.add(formatter.format(calendar.time))
            calendar.add(Calendar.DATE, 1)
        }
        return options
    }

    fun resetOrder() {
        _quantity.value = 0
        _flavour.value = ""
        _date.value = dateOptions[0]
        _price.value = 0.0
    }
}
