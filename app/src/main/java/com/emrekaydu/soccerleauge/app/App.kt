package com.emrekaydu.soccerleauge.app

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import com.emrekaydu.soccerleauge.app.extensions.RetrofitBuild
import com.emrekaydu.soccerleauge.app.services.Api
import retrofit2.Retrofit

class App: Application(){

    companion object {
        val retrofit = RetrofitBuild().getInstance()?.create(Api::class.java)
    }

    override fun onCreate() {
        super.onCreate()
    }
}