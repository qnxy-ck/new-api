package com.qnxy.newapi.data

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import com.qnxy.newapi.core.ApiException

/**
 * 请求头相关信息
 *
 * @author Qnxy
 */
data class ApiHeaderInfo(

    /**
     * 那个商户, 平台提供
     */
    val appId: String,

    /**
     * 当前请求时间戳 (UTC时区)
     *
     * 如果和平台系统时间相差 xx 秒, 将拒绝服务, 返回对应状态码
     */
    val timestamp: Long,

    /**
     * 随机字符
     */
    val nonce: String,

    /**
     * 接口请求数据签名
     * 用于验证请求接口参数
     *
     * 签名规则
     *  appId: xxx
     *  timestamp: xxx
     *  nonce: xxx
     *  singType: xx
     *  请求内容(如果存在)
     */
    val sign: String,

    /**
     * 签名算法类型
     */
    val signType: SignType = SignType.HMAC_SHA256

)

enum class SignType(
    @JsonValue
    val type: Int
) {

    HMAC_SHA256(0)

    ;

    companion object {

        @JsonCreator
        fun typeOf(type: Int) = values().find { it.type == type } ?: throw ApiException("Unsupported sign type $type")

    }
}
