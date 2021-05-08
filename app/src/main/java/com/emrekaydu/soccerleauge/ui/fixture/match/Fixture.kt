package com.emrekaydu.soccerleauge.ui.f

import android.util.Log
import com.emrekaydu.soccerleauge.ui.fixture.match.PairTeams
import com.emrekaydu.soccerleauge.ui.fixture.match.Week
import com.emrekaydu.soccerleauge.app.data.response.Team
import java.util.Collections.copy
import kotlin.collections.ArrayList

class Fixture(var data: ArrayList<Team>) {

    var weeks: MutableList<Week> = mutableListOf()
    private val pairedTeam: MutableList<PairTeams> = mutableListOf()
    var pivotId = 0




    fun matchTeams() {
        val teams = data.toMutableList()
        pivotId = teams[1].id
        var tempId = -1
        var tempPivot: Team

        if (data.size % 2 != 0){
            teams.add(Team(-2,"","***"))
        }

        while (tempId != pivotId) {
            for (index in 0 until teams.size/2) {
                val paired= addTeams(teams[index], teams[(data.size-1) - index])
                pairedTeam.add(paired)
            }

            tempPivot = teams.last().copy()

            for (index in 1..teams.size) {
                if(index == teams.size-1) {
                    break
                }
                teams[teams.size-index].id = teams[teams.size-index-1].id
                teams[teams.size-index].teamName = teams[teams.size-index-1].teamName
            }

            teams[1] = tempPivot
            tempId = tempPivot.id

        }
    }

    private fun addTeams(home: Team, away: Team): PairTeams {
        val homeTema = Team(home.id,"", home.teamName)
        val awayTeam = Team(away.id,"", away.teamName)
        return PairTeams(homeTema, awayTeam, 0)
    }

    fun markSeason() {
        for (index in 0 until pairedTeam.size) {
            val pair = pairedTeam[index]
            if (pairedTeam[index].season == 0) {
                pairedTeam[index].season = 1
            }
            val result = pairedTeam.find { it.away == pair.home && it.home == pair.away  }

            if (result?.season == 0) {
                val resultOfIndex = pairedTeam!!.indexOf(result)
                pairedTeam[resultOfIndex].season = 2
            }
        }
    }

    fun fillWeek() {

        var counter = 0
        pairedTeam.shuffle()
        pairedTeam.forEachIndexed { index, pairTeams ->
            if (weeks.isEmpty()) {
                  weeks.add(createWeek(counter))
            }

            if (weeks[counter].getNumberOfMatches() !=weeks[counter].getTeamNumber()){
                    weeks[counter].addTeam(pairTeams)
            } else {
                counter +=1
                weeks.add(createWeek(counter))
                weeks[counter].addTeam(pairTeams)
            }
        }
    }

    private fun createWeek(no: Int): Week {
        val week = Week(no)
        week.setNumberOfMatches(data.size/2)
        return week
    }



}


