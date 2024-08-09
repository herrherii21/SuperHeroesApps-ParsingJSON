package com.example.superheroesapps.model

    //Nama        : Heri ;
    //NIM         : 10121914 ;
    //Kelas       : IF9K ;
    //Mata Kuliah : Pemrograman Android ;
    //Dosen       : Rizki Adam Kurniawan S.Kom., M.Kom. ;
    //Selesai     : 09 Agustus 2024. 14:00 ;

import com.google.gson.annotations.SerializedName

data class Superhero(
    val name: String,
    val powerstats: PowerStats,
    val biography: Biography,
    val appearance: Appearance,
    val work: Work,
    val connections: Connections,
    val image: Image
)

data class PowerStats(
    val intelligence: String,
    val strength: String,
    val speed: String,
    val durability: String,
    val power: String,
    val combat: String
)

data class Biography(
    @SerializedName("full-name") val fullName: String,
    @SerializedName("alter-egos") val alterEgos: String,
    val aliases: List<String>,
    @SerializedName("place-of-birth") val placeOfBirth: String,
    @SerializedName("first-appearance") val firstAppearance: String,
    val publisher: String,
    val alignment: String
)

data class Appearance(
    val gender: String,
    val race: String,
    val height: List<String>,
    val weight: List<String>,
    @SerializedName("eye-color") val eyeColor: String,
    @SerializedName("hair-color") val hairColor: String
)

data class Work(
    val occupation: String,
    val base: String
)

data class Connections(
    @SerializedName("group-affiliation") val groupAffiliation: String,
    val relatives: String
)

data class Image(
    val url: String
)