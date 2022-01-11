package com.myapi.logisticAPI.domain.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.util.StringUtils
import myapi.com.br.logisticAPI.domain.exception.BusinessException
import myapi.com.br.logisticAPI.domain.model.Cliente
import myapi.com.br.logisticAPI.domain.repository.ClienteRepository

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


}