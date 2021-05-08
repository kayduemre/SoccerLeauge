package com.emrekaydu.soccerleauge.ui.fixture

import com.emrekaydu.soccerleauge.ui.fixture.match.Week

class FixtureContract {
    interface View {

        fun onDataSetChanged()
    }
    interface Presenter {
        fun bindView(view: View)
        fun onPressedSeasonOne()
        fun onPressedSeasonTwo()

    }
}