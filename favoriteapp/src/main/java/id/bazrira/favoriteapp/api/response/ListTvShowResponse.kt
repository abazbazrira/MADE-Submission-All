package id.bazrira.favoriteapp.api.response

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ListTvShowResponse(
    @SerializedName("original_name")
    @Expose
    var originalName: String? = null,
    @SerializedName("genre_ids")
    @Expose
    var genreIds: List<Int>? = null,
    @SerializedName("name")
    @Expose
    var name: String? = null,
    @SerializedName("popularity")
    @Expose
    var popularity: Double? = null,
    @SerializedName("origin_country")
    @Expose
    var originCountry: List<String>? = null,
    @SerializedName("vote_count")
    @Expose
    var voteCount: Int? = null,
    @SerializedName("first_air_date")
    @Expose
    var firstAirDate: String? = null,
    @SerializedName("backdrop_path")
    @Expose
    var backdropPath: String? = null,
    @SerializedName("original_language")
    @Expose
    var originalLanguage: String? = null,
    @SerializedName("id")
    @Expose
    var id: Int? = null,
    @SerializedName("vote_average")
    @Expose
    var voteAverage: Double? = null,
    @SerializedName("overview")
    @Expose
    var overview: String? = null,
    @SerializedName("poster_path")
    @Expose
    var posterPath: String? = null
) : Parcelable