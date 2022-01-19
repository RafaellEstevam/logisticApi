package com.myapi.logisticAPI.api.model.response

import java.time.OffsetDateTime

class OcorrenciaResponse(

    val id: Long,
    val descricao: String,
    val dataRegistro: OffsetDateTime
)
