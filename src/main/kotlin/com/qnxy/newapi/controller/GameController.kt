package com.qnxy.newapi.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.qnxy.newapi.data.ApiCommonState
import com.qnxy.newapi.data.ApiResult
import com.qnxy.newapi.data.req.GameLaunchReq
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.qnxy.newapi.data.ApiHeaderInfo
import com.qnxy.newapi.data.req.ModifyRtpReq
import com.qnxy.newapi.data.resp.GameItemResp
import org.springframework.web.bind.annotation.GetMapping

private val log = KotlinLogging.logger { }

/**
 * 游戏开放 API
 *
 * 所有接口都需要设置该请求头相关参数: [ApiHeaderInfo]
 *
 * @author Qnxy
 */
@RestController
@RequestMapping("/v3/game")
class GameController(
    private val objectMapper: ObjectMapper
) {

    /**
     * 获取游戏链接地址
     */
    @PostMapping("/launchUrl")
    fun launchUrl(@RequestBody gameLaunchReq: GameLaunchReq): ApiResult<String> {

        objectMapper.writeValueAsString(gameLaunchReq)
            .also { log.info { it } }

        return ApiResult.successful("game url")
    }


    /**
     * 获取游戏列表信息
     */
    @GetMapping("/list")
    fun list(): ApiResult<List<GameItemResp>> {

        return ApiResult.successful(
            listOf(
                GameItemResp("code", "name")
            )
        )
    }

    /**
     * 更新游戏RTP
     */
    @PostMapping("/modifyRtp")
    fun modifyRtp(@RequestBody modifyRtpReq: ModifyRtpReq): ApiResult<Void> {

        objectMapper.writeValueAsString(modifyRtpReq)
            .also { log.info { it } }

        return ApiResult.successful()
    }


}

