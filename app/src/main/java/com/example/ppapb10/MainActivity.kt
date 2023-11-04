package com.example.ppapb10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ppapb10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapterDisaster = DisasterAdapter(generateDummy()){disaster ->
            Toast.makeText(this@MainActivity,"Pahlawan ${disaster.nameDisaster}", Toast.LENGTH_SHORT).show()
        }
        with(binding){
            rvDisaster.apply {
                adapter = adapterDisaster
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }

    private fun generateDummy(): List<Disaster> {
        return listOf(
            Disaster(R.drawable.soedirman, "Jenderal Soedirman"),
            Disaster(R.drawable.nyi_ageng_serang, "Nyi Ageng Serang")
        )
    }
}