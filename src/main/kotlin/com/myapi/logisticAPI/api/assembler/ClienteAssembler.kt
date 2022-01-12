package com.myapi.logisticAPI.api.assembler

import com.myapi.logisticAPI.api.model.request.ClienteRequest
import com.myapi.logisticAPI.api.model.response.ClienteResponse
import com.myapi.logisticAPI.domain.model.Cliente
import org.springframework.stereotype.Component
import java.util.stream.Collectors

@Component
class ClienteAssembler {

    fun toEntity(clienteRequest: ClienteRequest): Cliente {

        return Cliente(nome = clienteRequest.nome, email =  clienteRequest.email, telefone = clienteRequest.telefone)

    }

    fun toResponseEntity(cliente: Cliente): ClienteResponse{

        return ClienteResponse(cliente.id!!, cliente.nome, cliente.email, cliente.telefone)
    }


    fun toResponseEntityCollection(clientes: List<Cliente>): List<ClienteResponse> {

        return clientes.stream().map { cliente -> this.toResponseEntity(cliente)}
            .collect(Collectors.toList())
    }


}