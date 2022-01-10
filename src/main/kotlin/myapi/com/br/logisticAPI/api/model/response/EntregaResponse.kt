package myapi.com.br.logisticAPI.api.model.response

import myapi.com.br.logisticAPI.domain.model.StatusEntrega
import java.math.BigDecimal
import java.time.OffsetDateTime

class EntregaResponse(

    val id: Long?,

    val nomeCliente: String,

    val taxa: BigDecimal,

    var dataPedido: OffsetDateTime?,

    var dataFinalizacao: OffsetDateTime? = null,

    var status: StatusEntrega?,

    val destinatario: DestinatarioResponse

    )