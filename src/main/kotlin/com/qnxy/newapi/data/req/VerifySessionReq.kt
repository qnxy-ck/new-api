package com.qnxy.newapi.data.req

/**
 * 验证商户会话
 *
 * @author qnxy
 */
data class VerifySessionReq (
    /**
     * 当前游戏用户会话标识
     *
     * 最大长度为: xxx
     */
    val gameSession: String,


)
