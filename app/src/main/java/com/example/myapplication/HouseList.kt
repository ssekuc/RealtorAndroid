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
    private var houseDataList: List<HouseData> = emptyList()

    companion object{
        val dataPrice = mutableListOf<String>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHouseListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        layoutManager = LinearLayoutManager (this)
        binding.recyclerView.layoutManager = layoutManager

        adapter = RecylerViewAdapter ()
        binding.recyclerView.adapter = adapter

        (adapter as? RecylerViewAdapter)?.updateData(emptyList())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.home_types_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val pricesApt = HouseData.getApartments()
        val pricesCondo = HouseData.getCondos()
        val pricesHouse = HouseData.getHouses()
        val pricesSemi = HouseData.getSemis()
        val pricesTown = HouseData.getTowns()

        when(item.itemId) {
            R.id.miApartment ->
                if (item.isChecked) {
                    item.setChecked(false)
                    dataPrice.addAll(pricesApt.map { it.price })
                } else {
                    item.setChecked(true)
                    dataPrice.removeAll(pricesApt.map { it.price })
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

        (adapter as? RecylerViewAdapter)?.updateData(dataPrice)
        adapter?.notifyDataSetChanged()

        return super.onOptionsItemSelected(item)
    }
}