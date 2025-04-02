package com.qnxy.newapi.data.req

import java.math.BigDecimal


data class GameLaunchReq(

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
    val currency: String,

    /**
     * 当前游戏语言
     * 如: en/pt/...
     * 默认: xx
     *
     * 具体支持情况请查看支持文档
     */
    val long: String = "en",

    /**
     * 当前游戏玩家唯一id
     *
     * 最大长度为: xxx
     */
    val playerUniqueId: String,

    /**
     * 用户当前 RTP
     * 如果该值为 0 或 null 则使用子商户rtp
     * 如果子商户没有设置 rtp 使用 商户的(商户为必填项)
     */
    val rtp: Int?,

    /**
     * 子商户编码
     * 如果不为空则使用子商户相关配置
     */
    val subMerchantCode: String?,

    /**
     * 游戏终端类型 [GameDisplayMode]
     * 默认为: PHONE(1)
     * 部分游戏暂未未支持 PC
     *
     * 具体支持情况请查看支持文档
     */
    val displayMode: GameDisplayMode = GameDisplayMode.PHONE,

    /**
     * 当前游戏用户会话标识
     *
     * 最大长度为: xxx
     */
    val gameSession: String,

    /**
     * 钱包类型 [WalletType]
     * 默认: 单一钱包
     */
    val walletType: WalletType = WalletType.CALLBACK,

    /**
     * 当前玩家余额
     *
     * 在钱包类型为
     *  单一钱包: 该值不会使用
     *  转账钱包: 该值必填并且要求大于零
     */
    val playerBalance: BigDecimal = BigDecimal.ZERO
)

/**
 * 游戏终端类型
 */
enum class GameDisplayMode(val mode: Int) {

    /**
     * pc 终端
     */
    PC(0),

    /**
     * 手机终端
     */
    PHONE(1),

}

/**
 * 钱包类型
 */
enum class WalletType(val mode: Int) {

    /**
     * 单一钱包
     * 平台主动回调
     */
    CALLBACK(0),

    /**
     * 转账钱包
     * 商户主动查询
     */
    QUERYING(1),
}