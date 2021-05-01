package com.emrekaydu.soccerleauge.app.services

import com.emrekaydu.soccerleauge.app.data.response.TeamsResponse
import com.rapunzel.rapunzelspecialist.app.data.response.BaseApiResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.*
interface Api {

//    GET("http://api.football-data.org/v2/competitions/2021/teams")
//    fun getTeamList()

    @GET("getTeamList")
    fun getTeams(): Single<Response<BaseApiResponse<TeamsResponse>>>

}