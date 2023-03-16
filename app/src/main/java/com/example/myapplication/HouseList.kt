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
        val dataImage = mutableListOf<String>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHouseListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        layoutManager = LinearLayoutManager (this)
        binding.recyclerView.layoutManager = layoutManager

        adapter = RecylerViewAdapter ()
        binding.recyclerView.adapter = adapter

        (adapter as? RecylerViewAdapter)?.updateData(emptyList(), emptyList())
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
                    dataPrice.removeAll(pricesApt.map { it.price })
                    dataImage.removeAll(pricesApt.map { it.picture })

                } else {
                    item.setChecked(true)
                    dataPrice.addAll(pricesApt.map { it.price })
                    dataImage.addAll(pricesApt.map { it.picture })
                }
            R.id.miTownHouse ->
                if (item.isChecked) {
                    item.setChecked(false)
                    dataPrice.removeAll (pricesTown.map { it.price })
                    dataImage.removeAll (pricesTown.map { it.picture })
                } else {
                    item.setChecked(true)
                    dataPrice.addAll(pricesTown.map { it.price })
                    dataImage.addAll(pricesTown.map { it.picture })
                }
            R.id.miCondo ->
                if (item.isChecked) {
                    item.setChecked(false)
                    dataPrice.removeAll(pricesCondo.map { it.price })
                    dataImage.removeAll(pricesCondo.map { it.picture })
                } else {
                    item.setChecked(true)
                    dataPrice.addAll(pricesCondo.map { it.price })
                    dataImage.addAll(pricesCondo.map { it.picture })
                }
            R.id.miSemi ->
                if (item.isChecked) {
                    item.setChecked(false)
                    dataPrice.removeAll(pricesSemi.map { it.price })
                    dataImage.removeAll(pricesSemi.map { it.picture })
                } else {
                    item.setChecked(true)
                    dataPrice.addAll(pricesSemi.map { it.price })
                    dataImage.addAll(pricesSemi.map { it.picture })
                }
            R.id.miDetached ->
                if (item.isChecked) {
                    item.setChecked(false)
                    dataPrice.removeAll(pricesHouse.map { it.price })
                    dataImage.removeAll(pricesHouse.map { it.picture })
                } else {
                    item.setChecked(true)
                    dataPrice.addAll(pricesHouse.map { it.price })
                    dataImage.addAll(pricesHouse.map { it.picture })
                }
        }

        (adapter as? RecylerViewAdapter)?.updateData(dataPrice, dataImage)
        adapter?.notifyDataSetChanged()

        return super.onOptionsItemSelected(item)
    }
}