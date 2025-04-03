package com.qnxy.newapi.data

import org.gradle.internal.impldep.org.joda.time.LocalDateTime
import java.time.ZonedDateTime

/**
 * Api返回结果
 * 接口 http 状态码统一返回 200
 *
 * 业务当前状态根据 状态码来决定
 *
 * @author Qnxy
 */

@Suppress("DATA_CLASS_COPY_VISIBILITY_WILL_BE_CHANGED_WARNING", "DataClassPrivateConstructor")
data class ApiResult<T> private constructor(
    /**
     * 当前状态描述消息
     */
    val statusMsg: String,

    /**
     * 当前状态码
     */
    val statusCode: String,

    /**
     * 当前时间戳信息
     * yyyy-MM-dd HH:mm:ss SSSXXX
     */
    val timestamp: ZonedDateTime = ZonedDateTime.now(),

    val data: T?
) {

    companion object {

        fun <T> successful(data: T? = null): ApiResult<T> {
            return ApiResult("ok", "ok", data = data)
        }

        fun <T, E> failure(status: E, data: T? = null, vararg args: Any): ApiResult<T> where E : ApiState, E : Enum<E> {
            return ApiResult(status.statusMsg(args), status.statusCode, data = data)
        }
    }
}

/**
 * API 状态接口声明
 */
interface ApiState {
    val statusCode: String

    fun statusMsg(vararg args: Any): String {
        TODO()
    }

}

/**
 * 公共状态定义
 */
enum class ApiCommonState : ApiState {

    SUCCESSFUL

    ;

    override val statusCode: String
        get() = this.name

}