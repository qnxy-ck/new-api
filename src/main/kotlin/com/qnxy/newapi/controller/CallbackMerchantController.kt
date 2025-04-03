package com.qnxy.newapi.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.qnxy.newapi.data.ApiResult
import com.qnxy.newapi.data.req.BetReq
import com.qnxy.newapi.data.req.VerifySessionReq
import com.qnxy.newapi.data.resp.BetResp
import com.qnxy.newapi.data.resp.VerifySessionResp
import com.sun.tools.javac.util.DefinedBy.Api
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

private val logger = KotlinLogging.logger {}

/**
 * 商户需要实现接口
 *
 * 平台回调商户
 *
 * @author Qnxy
 */
@RestController
@RequestMapping("/v3/game")
class CallbackMerchantController(
    private val objectMapper: ObjectMapper,
) {


    /**
     * 商户会话验证
     */
    @PostMapping("/verifySession")
    fun verifySession(@RequestBody verifySessionReq: VerifySessionReq): ApiResult<VerifySessionResp> {

        logger.info {
            "商户会话验证" +
                    objectMapper.writerWithDefaultPrettyPrinter()
                        .writeValueAsString(verifySessionReq)
        }

        return ApiResult.successful(
            VerifySessionResp(
                "user_name",
                "BR_BRL"
            )
        )
    }

    /**
     * 投注信息
     */
    @PostMapping("/bet")
    fun bet(@RequestBody betReq: BetReq): ApiResult<BetResp> {

        logger.info {
            "投注信息" +
                    objectMapper.writerWithDefaultPrettyPrinter()
                        .writeValueAsString(betReq)
        }

        return ApiResult.successful(
            BetResp(
                "order_no",
            )
        )
    }

}