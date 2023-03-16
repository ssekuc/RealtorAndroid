package com.example.myapplication

// Sample Data for Houses
data class HouseData(
    val price: String,
    val picture: String
) {
    companion object {
        fun getApartments(): List<HouseData> {
            return listOf(
                HouseData("$750.000", "apt1"),
                HouseData("$825.000", "apt2"),
                HouseData("$975.000", "apt3")
            )
        }
        fun getCondos(): List<HouseData> {
            return listOf(
                HouseData("$1.050.000", "condo1"),
                HouseData("$1.350.000", "condo2")
            )
        }
        fun getHouses(): List<HouseData> {
            return listOf(
                HouseData("$1.450.000", "house1"),
                HouseData("$1.600.000", "house2"),
                HouseData("$1.850.000", "house3")
            )
        }
        fun getSemis(): List<HouseData> {
            return listOf(
                HouseData("$1.450.000", "semi1"),
                HouseData("$1.100.000", "semi2"),
                HouseData("$1.250.000", "semi3")
            )
        }
        fun getTowns(): List<HouseData> {
            return listOf(
                HouseData("$1.100.000", "town1"),
                HouseData("$1.550.000", "town2"),
                HouseData("$1.125.000", "town3")
            )
        }
    }
}

