package com.myapi.logisticAPI.api.model.request

import javax.validation.constraints.NotBlank

class ClienteRequest(

    @field:NotBlank(message = "é obrigatório")
    val nome: String,

    @field:NotBlank(message = "é obrigatório")
    val email: String,

    @field:NotBlank(message = "é obrigatório")
    val telefone: String
)