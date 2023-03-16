package com.example.myapplication


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecylerViewAdapter : RecyclerView.Adapter<RecylerViewAdapter.ViewHolder>() {


    private var itemTitles = mutableListOf<String>()

    private var itemImages = mutableListOf<String>()


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
        holder.textTitle.text = itemTitles[position]
        val imageResourceId = holder.itemView.context.resources.getIdentifier(
            itemImages[position], "drawable", holder.itemView.context.packageName
        )
        Glide.with(holder.itemView)
            .load(imageResourceId)
            .placeholder(R.drawable.company_logo) // add a placeholder image
            .error(R.drawable.apt1)
            .into(holder.image)
    }


    fun updateData(data: List<String>, dataImage: List<String>) {
        itemTitles = data.toMutableList()
        itemImages = dataImage.toMutableList()
        notifyDataSetChanged()
    }
}