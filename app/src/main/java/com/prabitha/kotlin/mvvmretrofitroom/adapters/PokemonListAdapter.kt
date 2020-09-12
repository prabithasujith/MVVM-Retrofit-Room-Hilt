package com.prabitha.kotlin.mvvmretrofitroom.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.prabitha.kotlin.mvvmretrofitroom.R
import com.prabitha.kotlin.mvvmretrofitroom.models.Pokemon

class PokemonListAdapter() : RecyclerView.Adapter<PokemonViewHolder>() {

     private var pokemonList = ArrayList<Pokemon>(0)
    private lateinit var   mContext: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        this.mContext=parent.context
        val itemView =   LayoutInflater.from(parent.context). inflate(
            R.layout.list_item,
            parent,
            false
        )
        return PokemonViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val url: String =pokemonList[position].url
        val pokemonIndex = url.split("/").toTypedArray()
        val urlString="https://pokeres.bastionbot.org/images/pokemon/" + pokemonIndex[pokemonIndex.size - 2] + ".png"
       Glide.with(mContext).load(urlString).into(holder.imageView)

        holder.textView.text=pokemonList[position].name
    }

    override fun getItemCount(): Int {
       return  pokemonList.size
    }

    fun setData(list: List<Pokemon>){
        pokemonList.clear()
        pokemonList.addAll(list)
        notifyDataSetChanged()
    }
}

class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
val textView: TextView =itemView.findViewById(R.id.tvPokemonName)
    val imageView: ImageView =itemView.findViewById(R.id.imageView)
}