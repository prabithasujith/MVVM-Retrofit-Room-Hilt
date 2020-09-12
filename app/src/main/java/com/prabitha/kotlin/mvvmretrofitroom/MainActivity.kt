package com.prabitha.kotlin.mvvmretrofitroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.prabitha.kotlin.mvvmretrofitroom.adapters.PokemonListAdapter
import com.prabitha.kotlin.mvvmretrofitroom.models.Pokemon
import com.prabitha.kotlin.mvvmretrofitroom.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {



    @Inject
    lateinit var viewModel: MainViewModel
    lateinit var pokemon: List<Pokemon>

    val adapter = PokemonListAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        pokemonListView.adapter = adapter
        pokemonListView.layoutManager = LinearLayoutManager(this)

        viewModel.resultList?.observe(

            this, {
                if (it.isNotEmpty()) {
                    pokemon = it
                    adapter.setData(it)
                } else
                    viewModel.loadFromInternet()
            })


        searchBox.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(queryValue: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                 val query = newText.toString()
                if (query.isNotEmpty()) {
                    val list = ArrayList<Pokemon>()
                    for (it in pokemon) {
                        if (it.name.contains(query))
                            list.add(it)
                    }
                    adapter.setData(list)
                } else {
                    adapter.setData(pokemon)
                }
                return true
            }

        })
        searchBox.setOnCloseListener {
            adapter.setData(pokemon)
            false
        }
    }

}