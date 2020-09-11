package com.prabitha.kotlin.mvvmretrofitroom.models

data class PokemonResponse (val count:Int,val  next:String,val  previous:String,val   results:ArrayList<Pokemon>)