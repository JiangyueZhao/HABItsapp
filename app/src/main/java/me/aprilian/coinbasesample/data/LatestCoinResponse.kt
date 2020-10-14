package me.aprilian.coinbasesample.data
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LatestCoinResponse(
    @SerializedName("data")
    val `