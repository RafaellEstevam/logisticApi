package com.myapi.logisticAPI.domain.service

import com.myapi.logisticAPI.domain.exception.BusinessException
import com.myapi.logisticAPI.domain.model.Entrega
import com.myapi.logisticAPI.domain.model.StatusEntrega
import com.myapi.logisticAPI.domain.repository.ClienteRepository
import com.myapi.logisticAPI.domain.repository.EntregaRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.util.StringUtils

import java.time.OffsetDateTime

@Service
class EntregaService(val entregaRepository: EntregaRepository, val clienteRepository: ClienteRepository) {

    @Transactional
    fun registrar(entrega: Entrega): Entrega {

        if(!StringUtils.isEmpty(entrega.id)){

            val entregaOptional = entregaRepository.findById(entrega.id!!);

            if(!entregaOptional.isPresent){
                throw BusinessException("Entrega não encontrada!");
            }

            entrega.status = entregaOptional.get().status;
            entrega.dataPedido = entregaOptional.get().dataPedido;

        }else{
            entrega.status = StatusEntrega.PENDENTE;
            entrega.dataPedido = OffsetDateTime.now();
        }


        val clienteOptional = clienteRepository.findById(entrega.cliente.id!!);


        if(!clienteOptional.isPresent){
            throw BusinessException("Cliente não encontrado!");
        }

        entrega.cliente = clienteOptional.get();


         entregaRepository.save(entrega);

        return entrega;

    }


}