package me.aprilian.coinbasesample.data
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LatestCoinResponse(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("status")
    val status: Status
): Parcelable {
    @Parcelize
    data class Data(
        @SerializedName("circulating_supply")
        val circulatingSupply: Int?,
        @SerializedName("cmc_ra