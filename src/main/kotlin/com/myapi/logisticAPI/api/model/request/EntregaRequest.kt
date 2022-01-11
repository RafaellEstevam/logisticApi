package com.myapi.logisticAPI.api.model.request

import myapi.com.br.logisticAPI.api.model.request.ClienteIdRequest
import myapi.com.br.logisticAPI.api.model.request.DestinatarioRequest
import java.math.BigDecimal
import javax.validation.Valid
import javax.validation.constraints.NotNull

class EntregaRequest(

    @field:NotNull(message = "é obrigatório")
    val taxa: BigDecimal?,

    @field:NotNull(message = "é obrigatório")
    @field:Valid
    val cliente: ClienteIdRequest?,

    @field:NotNull(message = "é obrigatório")
    @field:Valid
    val destinatario: DestinatarioRequest?

)