package com.emrekaydu.soccerleauge.app.extensions

import io.reactivex.subjects.ReplaySubject
import io.reactivex.subjects.Subject

class ObservableVariable<T>(private val defaultValue: T?) {
    var value: T? = defaultValue
        set(value) {
            field = value
            value?.let {
                observable.onNext(value)
            }
        }
    var observable: Subject<T?> = ReplaySubject.create<T?>(1)
}
