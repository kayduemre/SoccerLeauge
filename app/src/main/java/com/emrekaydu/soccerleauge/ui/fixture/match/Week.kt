package com.emrekaydu.soccerleauge.ui.fixture.match

import android.util.Log
import com.emrekaydu.soccerleauge.app.data.response.Team

class Week(var no: Int) {

    private var teams:MutableList<PairTeams>? = mutableListOf()
    private var numberOfMatches: Int? = 0


    fun setNumberOfMatches(numberOfMatches: Int) {
        this.numberOfMatches = numberOfMatches
    }

    fun getNumberOfMatches(): Int? {
        return this.numberOfMatches
    }

    fun addTeam(pairedTeams: PairTeams) {
        pairedTeams.let {
            this.teams?.add(createPairTeam(it.away, it.home, it.season!!))
        }
    }

    private fun createPairTeam(away:Team, home: Team, season:Int): PairTeams {
        return PairTeams(away,home,season).copy()
    }

    fun getTeamNumber(): Int?{
        return this.teams?.size
    }

    fun getTeams(): MutableList<PairTeams>? {
        return this.teams
    }

    fun teamsShuffle() {
        teams?.shuffle()
    }
}