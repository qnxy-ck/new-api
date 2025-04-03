package com.qnxy.newapi.data.resp

import java.math.BigDecimal

/**
 * 商户金额转入返回信息
 *
 * @author qnxy
 */
data class TransferInResp (

    /**
     * 平台唯一交易码
     */
    val transactionId: String,

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
)



