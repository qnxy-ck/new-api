package com.qnxy.newapi.data.req

import java.math.BigDecimal

/**
 * 用户投注信息
 *
 * @author qnxy
 */
data class BetReq(
    /**
     * 当前游戏玩家唯一id
     *
     * 最大长度为: xxx
     */
    val playerUniqueId: String,

    /**
     * 游戏编码
     * 平台提供
     */
    val gameCode: String,

    /**
     * 游戏结算货币
     * 如：BR_BRL (巴西_雷亚尔)
     *
     * 具体支持情况请查看支持文档
     */
    val currencyCode: String,

    /**
     * 投注金额
     */
    val betAmount: BigDecimal,
)
