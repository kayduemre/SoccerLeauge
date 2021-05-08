package com.emrekaydu.soccerleauge.ui.fixture.controller

import android.os.Bundle
import com.airbnb.epoxy.EpoxyController
import com.emrekaydu.soccerleauge.app.App
import com.emrekaydu.soccerleauge.ui.fixture.match.Week
import com.emrekaydu.soccerleauge.ui.fixture.view_model.pairedTeams

class FixtureController:EpoxyController() {
    var season: Int? =1
    var week: Week? = null
    var weekIndex: Int = 0


    override fun buildModels() {
       App.fixture?.weeks!![weekIndex].getTeams()?.forEachIndexed { index, pairTeams ->
           pairedTeams {
               id(index)
               week(pairTeams)
               season(season!!)
           }
       }
    }
}