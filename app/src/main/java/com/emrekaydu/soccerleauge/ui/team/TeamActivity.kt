package com.emrekaydu.soccerleauge.ui.team

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.emrekaydu.soccerleauge.R
import com.emrekaydu.soccerleauge.app.base.BaseActivity
import com.emrekaydu.soccerleauge.app.data.response.TeamsResponse
import com.emrekaydu.soccerleauge.ui.team.controller.TeamController
import kotlinx.android.synthetic.main.activity_team.*

class TeamActivity: BaseActivity(), TeamContract.View {
    private val rvTeamList: RecyclerView by lazy { recyler_view_team }
    private var teamController: TeamController? = null

    private lateinit var teamViewModel: TeamViewModel
    override fun getContentViewResId(): Int {
        return R.layout.activity_team
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentViewResId())

        teamViewModel = ViewModelProvider(this, TeamViewModelFactory()).get(TeamViewModel::class.java)
        teamViewModel.bindView(this)

    }

    override fun onDataReady(teamsResponse: TeamsResponse) {
        teamController = TeamController()
        teamController!!.teams = teamsResponse
        teamController!!.context = this

        rvTeamList.apply {
            adapter = teamController!!.adapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        }
        teamController!!.requestModelBuild()
    }

    override fun onShowMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}