package com.myapi.logisticAPI.api.model.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

class OcorrenciaRequest(

    @field:NotBlank(message = "é obrigatório")
    val descricao: String
)