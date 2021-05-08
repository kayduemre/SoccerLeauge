package com.emrekaydu.soccerleauge.app.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class TeamsResponse(
    @SerializedName("statusCode")
    val statusCode: Int,
    @SerializedName("teams")
    val teams: ArrayList<Team>
): Parcelable

@Parcelize
data class Team(
    @SerializedName("id")
    var id: Int,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("teamName")
    var teamName: String
): Parcelable