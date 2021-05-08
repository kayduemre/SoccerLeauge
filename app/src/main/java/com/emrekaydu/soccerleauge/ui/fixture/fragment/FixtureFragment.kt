package com.emrekaydu.soccerleauge.ui.fixture.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.emrekaydu.soccerleauge.R
import com.emrekaydu.soccerleauge.app.App
import com.emrekaydu.soccerleauge.ui.fixture.controller.FixtureController
import com.emrekaydu.soccerleauge.ui.fixture.match.Week
import kotlinx.android.synthetic.main.fragment_week_screen_slide_page.*
import java.util.*

class FixtureFragment(var week: Week) : Fragment() {

    private val rvFixture: RecyclerView? by lazy { recyler_view_fixture }

    private var fixtureController: FixtureController?= null
    lateinit var tvWeekNo: TextView
    companion object {
        const val ARG_POSITION = "position"
        var season = 0
        fun getInstance(season: Int, position: Int, week: Week): Fragment {
            val fixtureFragment = FixtureFragment(week)
            val bundle = Bundle()
            bundle.putInt(ARG_POSITION, position)
            fixtureFragment.arguments = bundle
            this.season = season
            return fixtureFragment
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        fixtureController = FixtureController()
        return inflater.inflate(R.layout.fragment_week_screen_slide_page, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        onSeasonDataChanged()

        tvWeekNo = view.findViewById<TextView>(R.id.text_view_week_no)
        if (App.seasons == 1) {
            tvWeekNo.text = "Week " + week.no.plus(1).toString()
        } else if ( App.seasons == 2) {
            tvWeekNo.text = "Week " + week.no.plus(1+ App.teamsResponseList?.size!!).toString()
        }

        fixtureController!!.week = week
        fixtureController!!.season = season
        fixtureController!!.weekIndex = App.weekIndex.value!!

        rvFixture?.apply {
            adapter = fixtureController!!.adapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }

        fixtureController!!.requestModelBuild()
    }

    @SuppressLint("SetTextI18n")
    override fun onResume() {
        super.onResume()
        if (App.seasons == 1) {
            tvWeekNo.text = "Week " + week.no.plus(1).toString()
        } else if ( App.seasons == 2) {
            tvWeekNo.text = "Week " + week.no.plus(1+ App.teamsResponseList?.size!!).toString()
        }
        fixtureController!!.weekIndex = App.weekIndex.value!!
        fixtureController!!.requestModelBuild()
    }


    private fun onSeasonDataChanged() {
        App.onSeasonChanged = {old, new ->
            fixtureController?.requestModelBuild()
        }
    }

}