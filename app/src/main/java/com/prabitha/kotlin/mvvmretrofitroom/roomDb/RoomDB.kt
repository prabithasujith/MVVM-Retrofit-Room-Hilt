package com.prabitha.kotlin.mvvmretrofitroom.roomDb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.prabitha.kotlin.mvvmretrofitroom.models.Pokemon

@Database (entities = [Pokemon::class],version = 1,exportSchema = false)
abstract class RoomDB :RoomDatabase() {
    abstract fun RoomDAO(): RoomDAO
}