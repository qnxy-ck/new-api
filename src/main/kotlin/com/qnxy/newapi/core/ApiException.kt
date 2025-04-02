package com.qnxy.newapi.core

/**
 * @author Qnxy
 */
class ApiException(
    val msg: String? = null
) : RuntimeException(msg) {

}