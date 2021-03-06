package id.bazrira.favoriteapp.api.response

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NetworkResponse(
    @SerializedName("name")
    @Expose
    val name: String? = null,
    @SerializedName("id")
    @Expose
    val id: Int? = null,
    @SerializedName("logo_path")
    @Expose
    val logoPath: String? = null,
    @SerializedName("origin_country")
    @Expose
    val originCountry: String? = null
) : Parcelable