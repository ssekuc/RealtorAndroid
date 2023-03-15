package com.example.myapplication


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecylerViewAdapter : RecyclerView.Adapter<RecylerViewAdapter.ViewHolder>() {


    private var itemTitles = mutableListOf<String>()

    private val itemImages = intArrayOf(
        R.drawable.apt1,
        R.drawable.apt2,
        R.drawable.apt3,
        R.drawable.condo1,
        R.drawable.condo2,
        R.drawable.condo3,
        R.drawable.house1,
        R.drawable.house2,
        R.drawable.house3,
        R.drawable.semi1,
        R.drawable.semi2,
        R.drawable.semi3,
        R.drawable.town1,
        R.drawable.town2,
        R.drawable.town3
    )


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var image: ImageView
        var textTitle: TextView
        var addBut: Button

        init {
            image = itemView.findViewById(R.id.iv_house)
            textTitle = itemView.findViewById(R.id.tv_price)
            addBut = itemView.findViewById(R.id.btn_add)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.recylerview_model, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return itemTitles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textTitle.text = itemTitles [position]
        holder.image.setImageResource(itemImages [position])
    }

    fun updateData(data: List<String>) {
        itemTitles = data.toMutableList()
        notifyDataSetChanged()
    }
}