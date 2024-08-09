package com.example.superheroesapps.viewmodel

    //Nama        : Heri ;
    //NIM         : 10121914 ;
    //Kelas       : IF9K ;
    //Mata Kuliah : Pemrograman Android ;
    //Dosen       : Rizki Adam Kurniawan S.Kom., M.Kom. ;
    //Selesai     : 09 Agustus 2024. 14:00 ;

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.superheroesapps.api.SuperheroApi
import com.example.superheroesapps.api.RetrofitClient
import com.example.superheroesapps.model.Superhero
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SuperheroViewModel : ViewModel() {
    private val _superhero = MutableLiveData<Superhero>()
    val superhero: LiveData<Superhero> get() = _superhero

    init {
        fetchSuperhero()
    }

    private fun fetchSuperhero() {
        val api = RetrofitClient.instance.create(SuperheroApi::class.java)
        api.getSuperhero().enqueue(object : Callback<Superhero> {
            override fun onResponse(call: Call<Superhero>, response: Response<Superhero>) {
                if (response.isSuccessful) {
                    _superhero.value = response.body()
                }
            }

            override fun onFailure(call: Call<Superhero>, t: Throwable) {
                // Handle error
                // For example, set a default superhero or show an error message
            }
        })
    }
}