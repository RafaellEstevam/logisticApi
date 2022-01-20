package com.myapi.logisticAPI.domain.service

import com.myapi.logisticAPI.domain.exception.BusinessException
import com.myapi.logisticAPI.domain.model.Ocorrencia
import com.myapi.logisticAPI.domain.model.StatusEntrega
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

        val entrega = buscaEntregaService.buscar(entregaId)

        if(entrega.status != StatusEntrega.PENDENTE){
            throw BusinessException("Ocorrência não pôde ser registrada, pois esta entrega já está finalizada ou cancelada!")
        }

        ocorrencia.entrega = entrega

        ocorrencia.dataRegistro = OffsetDateTime.now()

        return ocorrenciaRepository.save(ocorrencia)
    }

}