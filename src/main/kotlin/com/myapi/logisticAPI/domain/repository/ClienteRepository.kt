package com.myapi.logisticAPI.domain.repository

import com.myapi.logisticAPI.domain.model.Cliente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ClienteRepository : JpaRepository<Cliente, Long> {

    fun findByEmail(email:String):Optional<Cliente>
}