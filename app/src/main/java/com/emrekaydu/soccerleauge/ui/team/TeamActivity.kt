package com.emrekaydu.soccerleauge.ui.team

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.emrekaydu.soccerleauge.R
import com.emrekaydu.soccerleauge.app.base.BaseActivity
import com.emrekaydu.soccerleauge.app.data.response.TeamsResponse
import com.emrekaydu.soccerleauge.ui.team.controller.TeamController
import kotlinx.android.synthetic.main.activity_team.*
import kotlinx.android.synthetic.main.include_header.*

class TeamActivity: BaseActivity(), TeamContract.View {
    private val rvTeamList: RecyclerView by lazy { recyler_view_team }
    private var teamController: TeamController? = null
    private val drawFixtureButton: Button by lazy { button_draw_fixture }
    private val headerName: TextView by lazy { text_view_header }

    private lateinit var teamViewModel: TeamViewModel
    override fun getContentViewResId(): Int {
        return R.layout.activity_team
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentViewResId())
        prepareUI()

        teamViewModel = ViewModelProvider(this, TeamViewModelFactory()).get(TeamViewModel::class.java)
        teamViewModel.bindView(this)

    }
    private fun prepareUI() {
        initHeader()
        clickListener()
    }
    @SuppressLint("SetTextI18n")
    private fun initHeader() {
        headerName.text = "Premier Leauge"

    }

    private fun clickListener() {
        drawFixtureButton.setOnClickListener {
            teamViewModel.pressedDrawFixtureButton(this)
        }
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