package com.qnxy.newapi.data

/**
 * Api返回结果
 * 接口 http 状态码统一返回 200
 *
 * 业务当前状态根据 状态码来决定
 *
 * @author Qnxy
 */

data class ApiResult<T> private constructor(
    /**
     * 当前状态描述消息
     */
    val statusMsg: String,

    /**
     * 当前状态码
     */
    val statusCode: String,
    val data: T?
) {

    companion object {

        fun <T> successful(data: T? = null): ApiResult<T> {
            return ApiResult<T>("ok", "ok", data)
        }

        fun <T, E> failure(status: E, data: T? = null, vararg args: Any): ApiResult<T> where E : ApiState, E : Enum<E> {
            return ApiResult<T>(status.statusMsg(args), status.statusCode, data)
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
enum class ApiCommonState(
    override val statusCode: String,
) : ApiState {

    SUCCESSFUL("C000001")

}