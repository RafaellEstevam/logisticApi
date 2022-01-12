package com.myapi.logisticAPI.api.controller

import com.myapi.logisticAPI.api.assembler.ClienteAssembler
import com.myapi.logisticAPI.api.model.request.ClienteRequest
import com.myapi.logisticAPI.api.model.response.ClienteResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import com.myapi.logisticAPI.domain.model.Cliente
import com.myapi.logisticAPI.domain.repository.ClienteRepository
import com.myapi.logisticAPI.domain.service.ClienteService
import javax.validation.Valid

@RestController
@RequestMapping("clientes")
class ClienteController(
    private val clienteRepository: ClienteRepository,
    private val clienteService: ClienteService,
    private val clienteAssembler: ClienteAssembler
) {

    @GetMapping
    fun listar(): List<ClienteResponse> {

        val clientes = clienteRepository.findAll()

        return clienteAssembler.toResponseEntityCollection(clientes)
    }

    @GetMapping("{clienteId}")
    fun buscar(@PathVariable clienteId: Long): ResponseEntity<ClienteResponse> {

        return clienteRepository.findById(clienteId)
            .map { cliente -> ResponseEntity.ok(clienteAssembler.toResponseEntity(cliente))}
            .orElse(ResponseEntity.notFound().build())
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun salvar(@RequestBody @Valid clienteRequest: ClienteRequest): ClienteResponse {

        var cliente = clienteAssembler.toEntity(clienteRequest)

        cliente = clienteService.salvar(cliente)

        return clienteAssembler.toResponseEntity(cliente)

    }

    @PutMapping("{clienteId}")
    fun atualizar(@PathVariable clienteId: Long, @RequestBody @Valid clienteRequest: ClienteRequest): ResponseEntity<ClienteResponse> {

        if (!clienteRepository.existsById(clienteId)) {
            return ResponseEntity.notFound().build()
        }

        var cliente = clienteAssembler.toEntity(clienteRequest)

        cliente.id = clienteId

        cliente = clienteService.salvar(cliente);

        return ResponseEntity.ok(clienteAssembler.toResponseEntity(cliente))
    }



    @DeleteMapping("{clienteId}")
    fun deletar(@PathVariable clienteId: Long):ResponseEntity<Any>{

        val clienteOptional = clienteRepository.findById(clienteId)

        if(!clienteOptional.isPresent){
            return ResponseEntity.notFound().build()
        }

        clienteService.deletar(clienteId)

        return ResponseEntity.noContent().build()

    }




}