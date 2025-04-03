package com.qnxy.newapi.data.req

/**
 * 商户用户余额记录查询
 *
 * @author qnxy
 */
data class TransactionReq(
    /**
     * 当前游戏玩家唯一id
     *
     * 最大长度为: xxx
     */
    val playerUniqueId: String,

    /**
     * 商户唯一单号
     */
    val transferReference: String

)
