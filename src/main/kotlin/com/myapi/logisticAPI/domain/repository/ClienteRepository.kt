package com.myapi.logisticAPI.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import myapi.com.br.logisticAPI.domain.model.Cliente
import java.util.*

@Repository
interface ClienteRepository : JpaRepository<Cliente, Long> {

    fun findByEmail(email:String):Optional<Cliente>
}