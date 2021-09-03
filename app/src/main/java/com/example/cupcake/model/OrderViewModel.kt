package com.example.cupcake.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrderViewModel : ViewModel() {
    private val _quantity: MutableLiveData<Int> = MutableLiveData(0)
    val quantity: LiveData<Int> get() = _quantity

    private val _flavour: MutableLiveData<String> = MutableLiveData("")
    val flavour: LiveData<String> get() = _flavour

    private val _date: MutableLiveData<String> = MutableLiveData("")
    val date: LiveData<String> get() = _date

    private val _price: MutableLiveData<Double> = MutableLiveData(0.0)
    val price: LiveData<Double> get() = _price

    fun setQuantity(numberCupcakes: Int) {
        _quantity.value = numberCupcakes
    }

    fun setFlavour(desiredFlavour: String) {
        _flavour.value = desiredFlavour
    }

    fun setDate(pickupDate: String) {
        _date.value = pickupDate
    }
}
