package com.prabitha.kotlin .mvvmretrofitroom.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.prabitha.kotlin.mvvmretrofitroom.models.Pokemon
import com.prabitha.kotlin.mvvmretrofitroom.repository.Repository
import javax.inject.Inject


class MainViewModel @Inject constructor(val repository: Repository): ViewModel() {
    var resultList: LiveData<List<Pokemon>>? = null

    init {
        resultList = repository.roomDAO.fetchPokemon()
    }


    fun loadFromInternet(){
        repository.getPokemons()   }
}