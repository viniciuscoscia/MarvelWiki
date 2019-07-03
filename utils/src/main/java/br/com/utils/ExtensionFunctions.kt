package br.com.utils

import java.math.BigInteger
import java.security.MessageDigest

fun String.toMD5(): String {
    val m = MessageDigest.getInstance("MD5")
    m.update(this.toByteArray(), 0, this.length)
    return BigInteger(1, m.digest()).toString(16)
}