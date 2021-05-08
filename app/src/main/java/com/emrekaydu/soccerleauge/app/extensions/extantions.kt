package com.emrekaydu.soccerleauge.app.extensions

fun <T> Array<T>.leftShift(d: Int) {
    val n = d % this.size  // just in case
    if (n == 0) return  // no need to shift

    val left = this.copyOfRange(0, n)
    val right = this.copyOfRange(n, this.size)
    System.arraycopy(right, 0, this, 0, right.size)
    System.arraycopy(left, 0, this, right.size, left.size)
}