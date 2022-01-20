package com.myapi.logisticAPI.domain.service

import com.myapi.logisticAPI.domain.exception.BusinessException
import com.myapi.logisticAPI.domain.model.StatusEntrega
import com.myapi.logisticAPI.domain.repository.EntregaRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class FinalizarEntregaService(private val entregaRepository: EntregaRepository) {

    @Transactional
    fun finalizar(entregaId: Long) {

        var entrega =
            entregaRepository.findById(entregaId).orElseThrow { BusinessException("Entrega não encontrada!") }

        if (entrega.status!! == StatusEntrega.PENDENTE) {
            entrega.status = StatusEntrega.FINALIZADA
        } else {
            throw BusinessException("Entrega não pode ser finalizada!")
        }

    }

}