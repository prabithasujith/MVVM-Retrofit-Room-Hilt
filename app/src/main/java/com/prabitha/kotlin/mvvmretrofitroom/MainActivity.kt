package com.prabitha.kotlin.mvvmretrofitroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prabitha.kotlin.mvvmretrofitroom.adapters.PokemonListAdapter
import com.prabitha.kotlin.mvvmretrofitroom.adapters.PokemonViewHolder
import com.prabitha.kotlin.mvvmretrofitroom.models.Pokemon
import com.prabitha.kotlin.mvvmretrofitroom.viewmodels.MainViewModel
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {



@Inject
lateinit var viewModel: MainViewModel

val adapter= PokemonListAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pokemonListView.adapter=adapter
        pokemonListView.layoutManager=LinearLayoutManager(this)

        viewModel.resultList?.observe(

            this, Observer {
if(it.size!=0) {
    adapter.setData(it)
}
                else
    viewModel.loadFromInternet()
            })

    }
}