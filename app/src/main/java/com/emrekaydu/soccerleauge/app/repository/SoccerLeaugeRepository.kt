package com.emrekaydu.soccerleauge.app.repository

import android.util.Log
import com.emrekaydu.soccerleauge.app.data.response.*
import com.emrekaydu.soccerleauge.app.services.Api
import com.rapunzel.rapunzelspecialist.app.data.enums.APIErrors
import com.rapunzel.rapunzelspecialist.app.data.response.BaseApiErrorDataResponse
import com.rapunzel.rapunzelspecialist.app.data.response.BaseApiErrorResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

import io.reactivex.schedulers.Schedulers

import retrofit2.Response
import com.emrekaydu.soccerleauge.app.data.enum.APIStatusCode as APIStatusCode

class SoccerLeaugeRepository(private val api: Api) {
    private val compositeDisposable = CompositeDisposable()

    fun getTeams(onSuccess: (TeamsResponse) ->Unit, onError: (BaseApiErrorResponse) -> Unit ){
        val disposable  = api.getTeams()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->

                if (response.isSuccessful){
                    if (response.code() == APIStatusCode.Success.value) {
                        Log.v("gelendata", response.toString())
                        onSuccess(response.body()?.data!!)
                    } else {
                        onError(BaseApiErrorResponse(response.code(), APIErrors.Unknown.value, null))
                    }
                }
            }, { error ->
                onError(BaseApiErrorResponse(null, null, listOf(BaseApiErrorDataResponse(APIErrors.Network.value, error.localizedMessage))))
            })
        compositeDisposable.add(disposable)
    }
}