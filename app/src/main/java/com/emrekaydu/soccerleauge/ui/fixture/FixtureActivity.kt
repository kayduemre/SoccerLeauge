package com.emrekaydu.soccerleauge.ui.fixture

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.emrekaydu.soccerleauge.R
import com.emrekaydu.soccerleauge.app.App
import com.emrekaydu.soccerleauge.ui.f.Fixture
import com.emrekaydu.soccerleauge.ui.fixture.adapter.FixtureAdapter
import com.emrekaydu.soccerleauge.ui.fixture.match.PairTeams
import kotlinx.android.synthetic.main.activity_fixture.*
import kotlinx.android.synthetic.main.include_header.*

class FixtureActivity: AppCompatActivity(), FixtureContract.View {

    private val vPagerFixture: ViewPager2? by lazy { view_pager_fixture }
    private val tvSeasonOneButton: TextView? by lazy { text_view_season_one }
    private val tvSeasonTwoButton: TextView? by lazy { text_view_season_two }
    private val tvHeader: TextView? by lazy { text_view_header }

    lateinit var fixture: Fixture

    private lateinit var fixtureAdapter: FixtureAdapter
    private var pairedTeams: MutableList<PairTeams> = mutableListOf()
    private lateinit var fixtureViewModel: FixtureViewModel

    companion object{
        fun launch(context: Context) {
            val intent = Intent(context, FixtureActivity::class.java)
            context.startActivity(intent)
        }
    }

    var fixturePageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            App.weekIndex.value = position
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentViewResId())
        tvHeader?.text   = "Fixture"

        fixtureViewModel = ViewModelProvider(this, FixtureViewModelFactory()).get(FixtureViewModel::class.java)

        fixtureViewModel.bindView(this)
        clickListener()

        fixture = Fixture(App.teamsResponseList!!)

        fixture.matchTeams()
        fixture.fillWeek()



        App.fixture = fixture

        fixtureAdapter = FixtureAdapter(this, fixture, 1)
        vPagerFixture?.adapter = fixtureAdapter

        vPagerFixture?.registerOnPageChangeCallback(fixturePageChangeCallback)


    }

    private fun clickListener() {
        tvSeasonOneButton?.setOnClickListener {
            fixtureViewModel.onPressedSeasonOne()
        }

        tvSeasonTwoButton?.setOnClickListener {
            fixtureViewModel.onPressedSeasonTwo()
        }
    }


    fun getContentViewResId(): Int {
        return R.layout.activity_fixture
    }

    override fun onDataSetChanged() {


        Handler().postDelayed({
            App.weekIndex.value = 0
            vPagerFixture?.setCurrentItem(0)
            fixtureAdapter.season = App.seasons
            App.fixture?.weeks?.forEachIndexed { index, week ->
                week.teamsShuffle()
            }
            fixtureAdapter.notifyDataSetChanged()
        },300)
    }

    override fun onDestroy() {
        super.onDestroy()
        vPagerFixture?.unregisterOnPageChangeCallback(fixturePageChangeCallback)

    }
}