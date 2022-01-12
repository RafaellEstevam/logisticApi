package com.myapi.logisticAPI.domain.service

import com.myapi.logisticAPI.domain.exception.BusinessException
import com.myapi.logisticAPI.domain.model.Cliente
import com.myapi.logisticAPI.domain.repository.ClienteRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.util.StringUtils

@Service
class ClienteService(private val clienteRepository: ClienteRepository) {


    @Transactional
    fun salvar(cliente: Cliente): Cliente {

        if (StringUtils.isEmpty(cliente.id)) {

            val clienteOptional = clienteRepository.findByEmail(cliente.email)

            if (clienteOptional.isPresent) {
                throw BusinessException("Cliente já cadastrado!")
            }

        }

        return clienteRepository.save(cliente);
    }

    @Transactional
    fun deletar(clienteId: Long) {
        clienteRepository.deleteById(clienteId);
    }


}