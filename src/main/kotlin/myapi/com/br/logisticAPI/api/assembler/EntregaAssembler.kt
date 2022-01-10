package myapi.com.br.logisticAPI.api.assembler


import org.springframework.stereotype.Component
import myapi.com.br.logisticAPI.api.model.request.EntregaRequest
import myapi.com.br.logisticAPI.api.model.response.DestinatarioResponse
import myapi.com.br.logisticAPI.api.model.response.EntregaResponse
import myapi.com.br.logisticAPI.domain.model.Cliente
import myapi.com.br.logisticAPI.domain.model.Destinatario
import myapi.com.br.logisticAPI.domain.model.Entrega
import kotlin.streams.toList

@Component
class EntregaAssembler() {


    fun toEntity(entregaRequest: EntregaRequest): Entrega {

        val cliente = Cliente(entregaRequest.cliente!!.id!!);

        val destinatario = this.buildDestinatario(entregaRequest);

        return Entrega(null, entregaRequest.taxa!!, null,null,null,
        cliente, destinatario);
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