package com.myapi.logisticAPI.domain.service

import com.myapi.logisticAPI.domain.exception.BusinessException
import com.myapi.logisticAPI.domain.model.Entrega
import com.myapi.logisticAPI.domain.repository.EntregaRepository
import org.springframework.stereotype.Service

@Service
class BuscaEntregaService(private val entregaRepository: EntregaRepository) {


    fun buscar(entregaId: Long): Entrega {
        return entregaRepository.findById(entregaId).orElseThrow { BusinessException("Entrega não encontrada!") }
    }

}