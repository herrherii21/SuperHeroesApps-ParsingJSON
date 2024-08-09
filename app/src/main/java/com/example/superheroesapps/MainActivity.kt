package com.example.superheroesapps

    //Nama        : Heri ;
    //NIM         : 10121914 ;
    //Kelas       : IF9K ;
    //Mata Kuliah : Pemrograman Android ;
    //Dosen       : Rizki Adam Kurniawan S.Kom., M.Kom. ;
    //Selesai     : 09 Agustus 2024. 14:00 ;

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.superheroesapps.databinding.ActivityMainBinding
import com.example.superheroesapps.viewmodel.SuperheroViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: SuperheroViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.superhero.observe(this, Observer { superhero ->
            binding.tvName.text = superhero.name
            binding.tvFullName.text = superhero.biography.fullName
            binding.tvIntelligence.text = ": ${superhero.powerstats.intelligence ?: "N/A"}"
            binding.tvStrength.text = ": ${superhero.powerstats.strength ?: "N/A"}"
            binding.tvSpeed.text = ": ${superhero.powerstats.speed ?: "N/A"}"
            binding.tvDurability.text = ": ${superhero.powerstats.durability ?: "N/A"}"
            binding.tvPower.text = ": ${superhero.powerstats.power ?: "N/A"}"
            binding.tvCombat.text = ": ${superhero.powerstats.combat ?: "N/A"}"
            binding.tvGender.text = ": ${superhero.appearance.gender ?: "N/A"}"
            binding.tvRace.text = ": ${superhero.appearance.race ?: "N/A"}"
            binding.tvHeight.text = ": ${superhero.appearance.height.joinToString(", ") ?: "N/A"}"
            binding.tvWeight.text = ": ${superhero.appearance.weight.joinToString(", ") ?: "N/A"}"
            binding.tvEyeColor.text = ": ${superhero.appearance.eyeColor ?: "N/A"}"
            binding.tvHairColor.text = ": ${superhero.appearance.hairColor ?: "N/A"}"
            binding.tvOccupation.text = ": ${superhero.work.occupation ?: "N/A"}"
            binding.tvBase.text = ": ${superhero.work.base ?: "N/A"}"
            binding.tvGroupAffiliation.text = ": ${superhero.connections.groupAffiliation ?: "N/A"}"
            binding.tvRelatives.text = ": ${superhero.connections.relatives ?: "N/A"}"

            Glide.with(this)
                .load(superhero.image.url)
                .into(binding.ivSuperhero)
        })
    }
}