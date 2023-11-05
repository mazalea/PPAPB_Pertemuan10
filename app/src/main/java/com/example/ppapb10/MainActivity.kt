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
        val deskripsiSoedirman: String = resources.getString(R.string.desc_soedirman)
        val deskripsiNyiAgengSerang: String = resources.getString(R.string.desc_nyiAgengSerang)
        val deskripsiHermanJohannes: String = resources.getString(R.string.desc_hermanJohannes)
        val deskripsiPierreTendean: String = resources.getString(R.string.desc_pierreTendean)
        val deskripsiSultanAgung: String = resources.getString(R.string.desc_sultanAgung)

        return listOf(
            Disaster(R.drawable.soedirman, "Jenderal Soedirman", deskripsiSoedirman),
            Disaster(R.drawable.nyi_ageng_serang, "Nyi Ageng Serang", deskripsiNyiAgengSerang),
            Disaster(R.drawable.herman_johannes, "Herman Johannes", deskripsiHermanJohannes),
            Disaster(R.drawable.pierre_tendean, "Pierre Tendean", deskripsiPierreTendean),
            Disaster(R.drawable.sultan_agung, "Sultan Agung", deskripsiSultanAgung)
        )
    }
}