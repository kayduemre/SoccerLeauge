package com.emrekaydu.soccerleauge.ui.team


import com.emrekaydu.soccerleauge.app.data.response.TeamsResponse
import com.rapunzel.rapunzelspecialist.app.data.response.BaseApiErrorResponse

class TeamContract {
    interface View {
        fun onDataReady(teamsResponse: TeamsResponse)
        fun onShowMessage(message: String)
    }
    interface Presenter {
        fun bindView(view: View)
        fun pressedDrawFixtureButton(activity: TeamActivity)

    }

    interface Interactor {
        fun getTeamList()
    }
    interface InteractorOutput {
        fun getTeamListSuccess(teamsResponse: TeamsResponse)
        fun onFailuer(error: BaseApiErrorResponse)
    }

    interface Router {
        fun presentFixtureScreen(activity: TeamActivity)
    }
}