package com.myapi.logisticAPI.domain.service

import com.myapi.logisticAPI.domain.model.Ocorrencia
import com.myapi.logisticAPI.domain.repository.OcorrenciaRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.OffsetDateTime

@Service
class OcorrenciaService(
    private val buscaEntregaService: BuscaEntregaService,
    private val ocorrenciaRepository: OcorrenciaRepository
) {

    @Transactional
    fun registrar(ocorrencia: Ocorrencia, entregaId: Long): Ocorrencia {

        ocorrencia.entrega = buscaEntregaService.buscar(entregaId)

        ocorrencia.dataRegistro = OffsetDateTime.now()

        return ocorrenciaRepository.save(ocorrencia)
    }

}