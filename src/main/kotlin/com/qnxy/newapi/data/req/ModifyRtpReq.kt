package com.qnxy.newapi.data.req

/**
 * 更新RTP请求信息
 *
 * @author qnxy
 */
data class ModifyRtpReq(

    /**
     * 更新的rtp
     */
    val changeRtp: Int,

    /**
     * 更新类型
     */
    val changeType: ChangeType = ChangeType.USER,

    /**
     * 类型对应参数
     * 如果类型为 [ChangeType.USER] 则为用户的 [GameLaunchReq.playerUniqueId]
     * 如果类型为 [ChangeType.SUB_MERCHANT] 则为子商户的code
     *
     */
    val changeCode: String
)

enum class ChangeType {

    /**
     * 某个用户
     */
    USER,

    /**
     * 子商户
     */
    SUB_MERCHANT,

}
