package com.qnxy.newapi.data.resp

/**
 * 会话验证返回结果
 *
 * @author qnxy
 */
data class VerifySessionResp(
    /**
     * 当前游戏玩家唯一id
     *
     * 最大长度为: xxx
     */
    val playerUniqueId: String,

    /**
     * 游戏结算货币
     * 如：BR_BRL (巴西_雷亚尔)
     *
     * 具体支持情况请查看支持文档
     */
    val currencyCode: String
)
