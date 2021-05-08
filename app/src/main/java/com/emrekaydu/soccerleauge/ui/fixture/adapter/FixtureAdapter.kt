package com.emrekaydu.soccerleauge.ui.fixture.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.emrekaydu.soccerleauge.ui.f.Fixture
import com.emrekaydu.soccerleauge.ui.fixture.fragment.FixtureFragment
import com.emrekaydu.soccerleauge.ui.fixture.match.Week


class FixtureAdapter(activity: AppCompatActivity, val fixture: Fixture,var  season:Int) :
    FragmentStateAdapter(activity) {


    override fun getItemCount(): Int {
        return fixture.weeks.size
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun createFragment(position: Int): Fragment {
        return FixtureFragment.getInstance(season, position, fixture.weeks.get(position))

    }


}
