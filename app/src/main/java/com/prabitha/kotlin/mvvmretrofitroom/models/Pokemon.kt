package com.prabitha.kotlin.mvvmretrofitroom.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "pokemon")
data class Pokemon ( var name:String,@PrimaryKey var url:String)