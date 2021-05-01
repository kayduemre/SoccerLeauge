package com.emrekaydu.soccerleauge.ui.team.controller

import android.content.Context
import android.util.Log
import com.airbnb.epoxy.EpoxyController
import com.emrekaydu.soccerleauge.app.data.response.TeamsResponse
import com.emrekaydu.soccerleauge.ui.team.view_model.teamItem

class TeamController: EpoxyController() {
    var teams: TeamsResponse? = null
    var context: Context? = null

    override fun buildModels() {
        Log.v("contr", teams.toString())
        teams?.teams?.forEachIndexed { index, team ->
            teamItem {
                id(index)
                teamId(team.id)
                teamName(team.teamName)
                logoImage(team.logo)
                context(context)
            }
        }
    }
}