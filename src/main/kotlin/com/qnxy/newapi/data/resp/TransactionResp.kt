package com.qnxy.newapi.data.resp

import java.math.BigDecimal

/**
 * 商户用户交易记录查询返回结果
 *
 * @author qnxy
 */
data class TransactionResp(
    /**
     * 平台唯一交易码
     */
    val transactionId: String,

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
    val currencyCode: String,

    /**
     * 交易金额
     */
    val amount: BigDecimal,

    /**
     * 交易前金额
     */
    val preTransactionAmount: BigDecimal,

    /**
     * 交易后金额
     */
    val amountAfterTransaction: BigDecimal,

    /**
     * 该笔交易方向
     */
    val transactionType: TransactionType
)


enum class TransactionType {

    /**
     * 转入
     * 商户转入
     */
    TRANSFER_IN,

    /**
     * 转出
     * 商户转出
     */
    TRANSFER_OUT

}
