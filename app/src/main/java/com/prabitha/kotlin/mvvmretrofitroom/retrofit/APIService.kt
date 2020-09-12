package com.prabitha.kotlin.mvvmretrofitroom.retrofit

import com.prabitha.kotlin.mvvmretrofitroom.models.PokemonResponse
import io.reactivex.Observable
import retrofit2.http.GET


interface APIService {
    @GET("pokemon")
    fun getPokemons(): Observable<PokemonResponse>
}