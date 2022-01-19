package com.myapi.logisticAPI.api.controller

import com.myapi.logisticAPI.api.assembler.OcorrenciaAssembler
import com.myapi.logisticAPI.api.model.request.OcorrenciaRequest
import com.myapi.logisticAPI.api.model.response.OcorrenciaResponse
import com.myapi.logisticAPI.domain.model.Entrega
import com.myapi.logisticAPI.domain.repository.OcorrenciaRepository
import com.myapi.logisticAPI.domain.service.OcorrenciaService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("entregas/{entregaId}/ocorrencias")
class OcorrenciaController(
    private val ocorrenciaRepository: OcorrenciaRepository,
    private val ocorrenciaAssembler: OcorrenciaAssembler,
    private val ocorrenciaService: OcorrenciaService
) {

    @GetMapping
    fun listar(): List<OcorrenciaResponse> {

        val ocorrencias = ocorrenciaRepository.findAll();

        return ocorrenciaAssembler.toResponseModelCollection(ocorrencias)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun registrar(@Valid @RequestBody ocorrenciaRequest: OcorrenciaRequest, @PathVariable entregaId: Long): OcorrenciaResponse{

        var ocorrencia = ocorrenciaAssembler.toEntity(ocorrenciaRequest)
        ocorrencia = ocorrenciaService.registrar(ocorrencia, entregaId)

        return ocorrenciaAssembler.toResponseModel(ocorrencia)

    }









}




















