package com.qnxy.newapi.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.qnxy.newapi.data.ApiResult
import com.qnxy.newapi.data.req.TransactionReq
import com.qnxy.newapi.data.req.TransferInReq
import com.qnxy.newapi.data.req.TransferOutReq
import com.qnxy.newapi.data.resp.TransactionResp
import com.qnxy.newapi.data.resp.TransactionType
import com.qnxy.newapi.data.resp.TransferInResp
import com.qnxy.newapi.data.resp.TransferOutResp
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal
import java.util.UUID

private val log = KotlinLogging.logger {}

/**
 * @author Qnxy
 */
@RestController
@RequestMapping("/V3/wallet")
class WalletController(
    private val objectMapper: ObjectMapper,
) {


    /**
     * 商户用户金额转入
     * 如果同一 [TransferInReq.transferReference] 为同一个, 将直接返回成功 不进行转入操作
     */
    @PostMapping("/transferIn")
    fun transferIn(@RequestBody transferIn: TransferInReq): ApiResult<TransferInResp> {

        log.info {
            "商户用户金额转入" + objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(transferIn)
        }

        return ApiResult.successful(
            TransferInResp(
                UUID.randomUUID().toString().replace("-", ""),
                BigDecimal.TEN,
                BigDecimal.ZERO,
                BigDecimal.TEN
            )
        )
    }

    /**
     * 商户用户金额转出
     */
    @PostMapping("/transferOut")
    fun transferOut(@RequestBody transferOutReq: TransferOutReq): ApiResult<TransferOutResp> {

        log.info {
            "商户用户金额转出" + objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(transferOutReq)
        }

        return ApiResult.successful(
            TransferOutResp(
                UUID.randomUUID().toString().replace("-", ""),
                BigDecimal.TEN,
                BigDecimal.TEN,
                BigDecimal.ZERO
            )
        )
    }

    /**
     * 商户余额记录查询
     */
    @PostMapping("/transaction")
    fun transaction(@RequestBody transactionReq: TransactionReq): ApiResult<TransactionResp> {

        log.info {
            "商户余额记录查询" + objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(transactionReq)
        }

        return ApiResult.successful(
            TransactionResp(
                UUID.randomUUID().toString().replace("-", ""),
                "user_001",
                "BR_BRL",
                BigDecimal.ONE,
                BigDecimal.ZERO,
                BigDecimal.ONE,
                TransactionType.TRANSFER_IN
            )
        )
    }

}