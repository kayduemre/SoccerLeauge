package com.emrekaydu.soccerleauge.ui.fixture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.emrekaydu.soccerleauge.app.App
import com.emrekaydu.soccerleauge.app.repository.SoccerLeaugeRepository
import com.emrekaydu.soccerleauge.ui.team.TeamViewModel
import java.lang.IllegalArgumentException

class FixtureViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FixtureViewModel::class.java)) {
            return FixtureViewModel(

            ) as T
        }
        throw IllegalArgumentException("unknown")
    }
}