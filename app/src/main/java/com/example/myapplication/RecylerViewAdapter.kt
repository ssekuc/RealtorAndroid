package com.example.myapplication


import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecylerViewAdapter : RecyclerView.Adapter<RecylerViewAdapter.ViewHolder>() {

    private val itemTitles = arrayOf("text1", "text2")

    private val itemImages = intArrayOf()


    inner class  ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

        var image : ImageView
        var textTitle : TextView
        var addBut : Button

        init {
            image = itemView.findViewById(R.id.iv_house)
            textTitle = itemView.findViewById(R.id.tv_price)
            addBut = itemView.findViewById(R.id.btn_add)
        }
    }
}