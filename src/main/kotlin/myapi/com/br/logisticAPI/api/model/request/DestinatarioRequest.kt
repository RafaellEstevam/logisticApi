package myapi.com.br.logisticAPI.api.model.request

import javax.persistence.Column
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

class DestinatarioRequest(

    @field:NotBlank(message = "é obrigatório")
    val nome: String?,

    @field:NotBlank(message = "é obrigatório")
    val logradouro: String?,

    @field:NotBlank(message = "é obrigatório")
    val numero: String?,

    @field:NotBlank(message = "é obrigatório")
    val complemento: String?,

    @field:NotBlank(message = "é obrigatório")
    val bairro: String?,
)
