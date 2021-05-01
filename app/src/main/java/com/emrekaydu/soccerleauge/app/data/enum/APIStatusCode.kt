package com.emrekaydu.soccerleauge.app.data.enum

enum class APIStatusCode(val value: Int) {
    Success(200),
    Server(500),
    UnAuthorized(403)
}