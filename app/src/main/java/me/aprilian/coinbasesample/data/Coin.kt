package me.aprilian.coinbasesample.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Coin(
    val id: Long,
    val name: String,
    val symbol: String,
    val price: Long,
    val growth: Double
) : Parcelable {
    companion object {
        suspend fun getSample(): ArrayList<Coin>{
            return arrayListOf(
                Coin(1, "Bitcoin", "BTC", 3000000, 2.67),
                Coin(2, "DogeCoin", "DOGE",