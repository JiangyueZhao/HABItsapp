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
    companion obje