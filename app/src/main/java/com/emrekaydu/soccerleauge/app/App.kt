package com.emrekaydu.soccerleauge.app

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.emrekaydu.soccerleauge.app.data.response.Team
import com.emrekaydu.soccerleauge.app.data.response.TeamsResponse
import com.emrekaydu.soccerleauge.app.extensions.ObservableVariable
import com.emrekaydu.soccerleauge.app.extensions.RetrofitBuild
import com.emrekaydu.soccerleauge.app.services.Api
import com.emrekaydu.soccerleauge.ui.f.Fixture
import com.emrekaydu.soccerleauge.ui.fixture.fragment.FixtureFragment
import com.emrekaydu.soccerleauge.ui.fixture.match.PairTeams
import com.emrekaydu.soccerleauge.ui.fixture.match.Week
import retrofit2.Retrofit
import kotlin.properties.Delegates

class App: Application(){

    companion object {
        var seasonsOne: MutableList<Week>? = null
        var seasonsTwo: MutableList<Week>? = null
        var fixture: Fixture? = null
        val retrofit = RetrofitBuild().getInstance()?.create(Api::class.java)
        var teamsResponseList: ArrayList<Team>? = null

        var weekIndex: ObservableVariable<Int> = ObservableVariable(0)
        var seasons: Int by Delegates.observable(1){_,old, new->
            onSeasonChanged?.invoke(old, new)
        }

        var onSeasonChanged:((Int, Int) ->Unit)? = null
    }

    override fun onCreate() {
        super.onCreate()

    }
}