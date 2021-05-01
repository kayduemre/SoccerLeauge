package com.rapunzel.rapunzelspecialist.app.data.response

import com.google.gson.annotations.SerializedName

data class BaseApiResponse<T> (
    @SerializedName("message") val message : String,
    @SerializedName("data") val data : T
)

data class BaseApiErrorResponse(
    @SerializedName("errorCode") val errorCode : Int? = null,
    @SerializedName("message") val message : String? = null,
    @SerializedName("errors") val errors : List<BaseApiErrorDataResponse>? = null
)

data class BaseApiErrorDataResponse(
    @SerializedName("field") val field : String? = null,
    @SerializedName("message") val message : String? = null
)

data class ApiErrorResponse(
    @SerializedName("statusCode") val errorCode : Int? = null,
    @SerializedName("error") val error : String? = null,
    @SerializedName("message") val message : String? = null
)