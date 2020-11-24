package com.example.indonesiacoronawebinar

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.indonesiacoronawebinar.model.KasusCoronaProvinsi

class ProvinsiAdapter(val dataCovidProvinsi: KasusCoronaProvinsi?) : RecyclerView.Adapter<ProvinsiAdapter.ViewHolder>()   {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_provinsi_covid, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int= dataCovidProvinsi?.size ?:0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataCovidProvinsis = dataCovidProvinsi?.get(position)

        holder.txtKasusProv?.text = dataCovidProvinsis?.attributes?.kasusPosi.toString()
        holder.txtNamaProvinsi?.text = dataCovidProvinsis?.attributes?.provinsi
        holder.txtMeninggalProv?.text = dataCovidProvinsis?.attributes?.kasusMeni.toString()
        holder.txtSembuhProv?.text = dataCovidProvinsis?.attributes?.kasusSemb.toString()


    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val txtNamaProvinsi: TextView? = itemView.findViewById(R.id.tvNamaProvinsi)
        val txtKasusProv: TextView?= itemView.findViewById(R.id.tvKasusProv);
        val txtSembuhProv: TextView? = itemView.findViewById(R.id.tvSembuhProv);
        val txtMeninggalProv: TextView? = itemView.findViewById(R.id.tvMeninggalProv);
    }



}