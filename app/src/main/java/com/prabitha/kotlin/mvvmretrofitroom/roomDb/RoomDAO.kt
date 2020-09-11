package com.prabitha.kotlin.mvvmretrofitroom.roomDb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.prabitha.kotlin.mvvmretrofitroom.models.Pokemon


@Dao
interface RoomDAO {

@Insert
    fun insertPokemon(pokemon:Pokemon)

    @Query("SELECT * FROM pokemon")
    fun fetchPokemon(): LiveData<List<Pokemon>>

}