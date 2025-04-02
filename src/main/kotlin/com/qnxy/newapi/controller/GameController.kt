package com.qnxy.newapi.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.qnxy.newapi.data.ApiCommonState
import com.qnxy.newapi.data.ApiResult
import com.qnxy.newapi.data.req.GameLaunchReq
import io.github.oshai.kotlinlogging.KotlinLogging
import kotlinx.coroutines.delay
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.qnxy.newapi.data.ApiHeaderInfo
import com.qnxy.newapi.data.GameItem

private val log = KotlinLogging.logger { }

/**
 * 游戏开放 API
 *
 * 所有接口都需要设置该请求头相关参数: [ApiHeaderInfo]
 *
 * @author Qnxy
 */
@RestController
@RequestMapping("/game/v3")
class GameController(
    private val objectMapper: ObjectMapper
) {

    /**
     * 获取游戏链接地址
     */
    @PostMapping("/gameLaunchUrl")
    fun gameLaunchUrl(@RequestBody gameLaunchReq: GameLaunchReq): ApiResult<String> {

        objectMapper.writeValueAsString(gameLaunchReq)
            .also { log.info { it } }

        return ApiResult.successful("game url")
    }


    /**
     *
     */
    @PostMapping("/gameList")
    fun gameList(): ApiResult<List<GameItem>> {

        return ApiResult.successful(
            listOf(
                GameItem(
                    "code",
                    "name",
                )
            )
        )
    }

}

