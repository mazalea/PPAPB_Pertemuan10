package com.example.ppapb10

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ppapb10.databinding.ItemPahlawanBinding

typealias onClickDisaster = (Pahlawan) -> Unit

class PahlawanAdapter(private val listPahlawan: List<Pahlawan>, private val onClickDisaster: onClickDisaster):
    RecyclerView.Adapter<PahlawanAdapter.ItemPahlawanViewHolder>() {

    inner class ItemPahlawanViewHolder(private val binding: ItemPahlawanBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Pahlawan) {
            with(binding) {
                txtPahlawanName.text = data.namePahlawan
                txtDescription.text = data.descPahlawan

                val gambar_pahlawan = when (data.gambarPahlawan) {
                    R.drawable.soedirman -> R.drawable.soedirman
                    R.drawable.nyi_ageng_serang -> R.drawable.nyi_ageng_serang
                    R.drawable.herman_johannes -> R.drawable.herman_johannes
                    R.drawable.pierre_tendean -> R.drawable.pierre_tendean
                    R.drawable.sultan_agung -> R.drawable.sultan_agung
                    else -> R.drawable.default_img
                }

                imgPahlawan.setImageResource(gambar_pahlawan)

                itemView.setOnClickListener {
                    onClickDisaster(data)
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemPahlawanViewHolder {
        val binding = ItemPahlawanBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)
        return ItemPahlawanViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemPahlawanViewHolder, position: Int) {
        holder.bind(listPahlawan[position])
    }

    override fun getItemCount(): Int = listPahlawan.size

}