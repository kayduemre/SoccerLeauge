package com.emrekaydu.soccerleauge.ui.fixture

import androidx.lifecycle.ViewModel
import com.emrekaydu.soccerleauge.app.App
import com.emrekaydu.soccerleauge.ui.fixture.match.Week

class FixtureViewModel: ViewModel(), FixtureContract.Presenter {
    lateinit var view: FixtureContract.View
    override fun bindView(view: FixtureContract.View) {
        this.view = view
    }

    override fun onPressedSeasonOne() {
        App.seasons = 1
        view.onDataSetChanged()
    }

    override fun onPressedSeasonTwo() {
        App.seasons = 2
        view.onDataSetChanged()
    }

}