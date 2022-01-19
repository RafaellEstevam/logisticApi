package com.myapi.logisticAPI.api.controller

import com.myapi.logisticAPI.api.assembler.EntregaAssembler
import com.myapi.logisticAPI.api.model.request.EntregaRequest
import com.myapi.logisticAPI.api.model.response.EntregaResponse
import com.myapi.logisticAPI.domain.repository.EntregaRepository
import com.myapi.logisticAPI.domain.service.EntregaService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

import javax.validation.Valid

@RestController
@RequestMapping("entregas")
class EntregaController(private val entregaRepository: EntregaRepository, private val entregaAssembler: EntregaAssembler,
                        val entregaService: EntregaService
) {


    @GetMapping
    fun listar(): List<EntregaResponse>{

        return entregaAssembler.toResponseModelCollection(entregaRepository.findAll());
    }


    @GetMapping("{entregaId}")
    fun buscar(@PathVariable entregaId: Long): ResponseEntity<EntregaResponse>{

        return entregaRepository.findById(entregaId).map { entrega -> ResponseEntity.ok(entregaAssembler.toResponseModel(entrega))}
            .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun registrar(@Valid @RequestBody entregaRequest: EntregaRequest): EntregaResponse {

        val entrega = entregaService.registrar(entregaAssembler.toEntity(entregaRequest));

        return entregaAssembler.toResponseModel(entrega);

    }

    @PutMapping("{entregaId}")
    fun atualizar(@PathVariable entregaId: Long, @Valid @RequestBody entregaRequest: EntregaRequest){

        val entrega = entregaAssembler.toEntity(entregaRequest);

        entrega.id = entregaId;

        entregaService.registrar(entrega);

    }




}














