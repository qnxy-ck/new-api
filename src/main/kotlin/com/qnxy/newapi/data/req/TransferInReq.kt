package com.qnxy.newapi.data.req

import java.math.BigDecimal

data class TransferInReq(
    /**
     * 当前游戏玩家唯一id
     *
     * 最大长度为: xxx
     */
    val playerUniqueId: String,

    /**
     * 操作金额
     */
    val amount: BigDecimal,

    /**
     * 商户唯一单号
     */
    val transferReference: String,

    /**
     * 游戏结算货币
     * 如：BR_BRL (巴西_雷亚尔)
     *
     * 具体支持情况请查看支持文档
     */
    val currencyCode: String
)
