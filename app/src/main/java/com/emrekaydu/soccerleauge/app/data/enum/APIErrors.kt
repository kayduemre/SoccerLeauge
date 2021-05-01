package com.rapunzel.rapunzelspecialist.app.data.enums

enum class APIErrors(val value: String) {
    Network("Network"),
    Internal("Internal"),
    Unknown("Bilinmeyen bir hata oluştu"),
    BadRequest("Girmiş olduğunuz bilgiler hatalı")
}
