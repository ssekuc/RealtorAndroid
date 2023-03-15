package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.CheckBox
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityHouseListBinding

class HouseList : AppCompatActivity() {
    private lateinit var binding: ActivityHouseListBinding
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecylerViewAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHouseListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        layoutManager = LinearLayoutManager (this)
        binding.recyclerView.layoutManager = layoutManager

        adapter = RecylerViewAdapter ()
        binding.recyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.home_types_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.miApartment ->
                if (item.isChecked) {
                    item.setChecked(false)
                } else {
                    item.setChecked(true)
                }
            R.id.miTownHouse ->
                if (item.isChecked) {
                    item.setChecked(false)
                } else {
                    item.setChecked(true)
                }
            R.id.miCondo ->
                if (item.isChecked) {
                    item.setChecked(false)
                } else {
                    item.setChecked(true)
                }
            R.id.miSemi ->
                if (item.isChecked) {
                    item.setChecked(false)
                } else {
                    item.setChecked(true)
                }
            R.id.miDetached ->
                if (item.isChecked) {
                    item.setChecked(false)
                } else {
                    item.setChecked(true)
                }
        }

        return super.onOptionsItemSelected(item)
    }
}