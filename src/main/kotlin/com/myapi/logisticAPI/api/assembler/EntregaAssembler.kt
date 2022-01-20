package com.myapi.logisticAPI.api.assembler


import com.myapi.logisticAPI.api.model.request.EntregaRequest
import com.myapi.logisticAPI.api.model.response.DestinatarioResponse
import com.myapi.logisticAPI.api.model.response.EntregaResponse
import com.myapi.logisticAPI.domain.model.Cliente
import com.myapi.logisticAPI.domain.model.Destinatario
import com.myapi.logisticAPI.domain.model.Entrega
import org.springframework.stereotype.Component
import kotlin.streams.toList

@Component
class EntregaAssembler() {


    fun toEntity(entregaRequest: EntregaRequest): Entrega {

        val cliente = Cliente(entregaRequest.cliente!!.id!!);

        val destinatario = this.buildDestinatario(entregaRequest);

        return Entrega(taxa = entregaRequest.taxa!!, dataPedido =  null, dataFinalizacao = null, status = null,
        cliente = cliente, destinatario = destinatario);
    }

    fun toResponseModel(entrega: Entrega): EntregaResponse {


        val destinatarioResponse = this.buildDestinatarioResponse(entrega.destinatario);

        return EntregaResponse(entrega.id, entrega.cliente.nome, entrega.taxa,
        entrega.dataPedido, entrega.dataFinalizacao, entrega.status, destinatarioResponse)

    }


    fun toResponseModelCollection(entregas: List<Entrega>): List<EntregaResponse>{

        return entregas.stream()
            .map(this :: toResponseModel)
            .toList();
    }


    fun buildDestinatarioResponse(destinatario: Destinatario): DestinatarioResponse {

        return DestinatarioResponse(destinatario.nome, destinatario.logradouro,
            destinatario.numero, destinatario.complemento, destinatario.bairro);

    }

    fun buildDestinatario(entregaRequest: EntregaRequest): Destinatario {

        return Destinatario(
            entregaRequest.destinatario!!.nome!!, entregaRequest.destinatario.logradouro!!,
            entregaRequest.destinatario.numero!!, entregaRequest.destinatario.complemento!!, entregaRequest.destinatario.bairro!!
        )
    }

}