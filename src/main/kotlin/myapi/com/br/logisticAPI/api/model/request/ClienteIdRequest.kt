package myapi.com.br.logisticAPI.api.model.request

import javax.validation.constraints.NotNull

class ClienteIdRequest(

    @field:NotNull(message = "é obrigatório")
    val id: Long?
)
