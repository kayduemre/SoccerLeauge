package com.emrekaydu.soccerleauge.ui.fixture

import android.content.Context
import android.content.Intent
import com.emrekaydu.soccerleauge.R
import com.emrekaydu.soccerleauge.app.base.BaseActivity
import java.util.zip.Inflater

class FixtureActivity: BaseActivity() {

    companion object{
        fun launch(context: Context) {
            val intent = Intent(context, FixtureActivity::class.java)
            context.startActivity(intent)
        }
    }
    override fun getContentViewResId(): Int {
        return R.layout.activity_fixture
    }
}