package com.prabitha.kotlin.mvvmretrofitroom.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.prabitha.kotlin.mvvmretrofitroom.models.Pokemon
import com.prabitha.kotlin.mvvmretrofitroom.models.PokemonResponse
import com.prabitha.kotlin.mvvmretrofitroom.retrofit.APIService
import com.prabitha.kotlin.mvvmretrofitroom.roomDb.RoomDAO
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class Repository @Inject constructor(val apiService:APIService, val roomDAO: RoomDAO) {
    fun getPokemons() {
        Log.d("repository" ," fetching from  the network")
        apiService.getPokemons().subscribeOn(Schedulers.io())
            .subscribe{it->  insertPokemon(it.results)}
    }

    private fun insertPokemon(list:ArrayList<Pokemon>) {
        Log.d("repository" ," adding into the db ${list.size}")
        for(i in 0 until list.size) {
            roomDAO.insertPokemon(list[i])
        }
    }




}