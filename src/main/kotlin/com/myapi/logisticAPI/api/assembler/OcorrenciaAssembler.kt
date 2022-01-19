package com.myapi.logisticAPI.api.assembler

import com.myapi.logisticAPI.api.model.request.OcorrenciaRequest
import com.myapi.logisticAPI.api.model.response.OcorrenciaResponse
import com.myapi.logisticAPI.domain.model.Ocorrencia
import org.springframework.stereotype.Component
import kotlin.streams.toList

@Component
class OcorrenciaAssembler {

    fun toResponseModel(ocorrencia: Ocorrencia): OcorrenciaResponse {
        return OcorrenciaResponse(ocorrencia.id!!, ocorrencia.descricao, ocorrencia.dataRegistro!!)
    }

    fun toResponseModelCollection(ocorrencias: List<Ocorrencia>): List<OcorrenciaResponse> {
        return ocorrencias.stream().map { ocorrencia -> this.toResponseModel(ocorrencia) }
            .toList()
    }

    fun toEntity(ocorrenciaRequest: OcorrenciaRequest): Ocorrencia {
        return Ocorrencia(null, ocorrenciaRequest.descricao, null, null)
    }

}