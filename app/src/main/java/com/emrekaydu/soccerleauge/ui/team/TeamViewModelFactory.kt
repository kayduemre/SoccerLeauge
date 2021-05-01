package com.emrekaydu.soccerleauge.ui.team

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.emrekaydu.soccerleauge.app.App
import com.emrekaydu.soccerleauge.app.repository.SoccerLeaugeRepository
import com.emrekaydu.soccerleauge.app.services.Api
import java.lang.IllegalArgumentException

class TeamViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TeamViewModel::class.java)) {
            return TeamViewModel(
                repository = SoccerLeaugeRepository(App.retrofit!!)
            ) as T
        }
        throw IllegalArgumentException("unknow")
    }
}