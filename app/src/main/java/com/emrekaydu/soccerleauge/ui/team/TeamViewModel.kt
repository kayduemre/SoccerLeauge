package com.emrekaydu.soccerleauge.ui.team

import android.util.Log
import androidx.lifecycle.ViewModel
import com.emrekaydu.soccerleauge.app.data.response.TeamsResponse
import com.emrekaydu.soccerleauge.app.repository.SoccerLeaugeRepository
import com.emrekaydu.soccerleauge.ui.fixture.FixtureActivity
import com.rapunzel.rapunzelspecialist.app.data.response.BaseApiErrorResponse

class TeamViewModel(private val repository: SoccerLeaugeRepository): ViewModel(), TeamContract.Presenter, TeamContract.Interactor, TeamContract.InteractorOutput, TeamContract.Router {

    lateinit var view: TeamContract.View


    override fun bindView(view: TeamContract.View) {
        this.view = view
        getTeamList()
    }

    override fun pressedDrawFixtureButton(activity: TeamActivity) {
        pressedDrawFixtureButton(activity)
    }

    override fun getTeamList() {
        repository.getTeams(onSuccess = { teamsResponse ->
            teamsResponse.let {
                getTeamListSuccess(teamsResponse)
            }
        }, onError = { error ->
            onFailuer(error)
        })
    }

    override fun getTeamListSuccess(teamsResponse: TeamsResponse) {
       view.onDataReady(teamsResponse)
    }

    override fun onFailuer(error: BaseApiErrorResponse) {


        Log.v("datatgeldi", error.toString())
    }

    override fun presentFixtureScreen(activity: TeamActivity) {
        FixtureActivity.launch(activity)
    }
}