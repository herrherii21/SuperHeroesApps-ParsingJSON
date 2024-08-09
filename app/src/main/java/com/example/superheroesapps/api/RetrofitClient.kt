package com.example.superheroesapps.api

    //Nama        : Heri ;
    //NIM         : 10121914 ;
    //Kelas       : IF9K ;
    //Mata Kuliah : Pemrograman Android ;
    //Dosen       : Rizki Adam Kurniawan S.Kom., M.Kom. ;
    //Selesai     : 09 Agustus 2024. 14:00 ;

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://www.superheroapi.com/"

    val instance: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}