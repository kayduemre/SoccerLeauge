package com.emrekaydu.soccerleauge.ui.fixture.match

import com.emrekaydu.soccerleauge.app.data.response.Team
import com.emrekaydu.soccerleauge.app.data.response.TeamsResponse

data class PairTeams(var away: Team, var home: Team, var season: Int? = null)



