package com.myapi.logisticAPI.domain.service

import com.myapi.logisticAPI.domain.exception.BusinessException
import com.myapi.logisticAPI.domain.model.StatusEntrega
import com.myapi.logisticAPI.domain.repository.EntregaRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.OffsetDateTime

@Service
class CancelarEntregaService(private val entregaRepository: EntregaRepository) {

    @Transactional
    fun cancelar(entregaId: Long) {
        var entrega = entregaRepository.findById(entregaId).orElseThrow { BusinessException("Entrega não encontrada!") }

        if (entrega.status == StatusEntrega.PENDENTE) {
            entrega.status = StatusEntrega.CANCELADA
            entrega.dataFinalizacao = OffsetDateTime.now()
        } else {
            throw BusinessException("Entrega não pode ser cancelada!")
        }
    }
}