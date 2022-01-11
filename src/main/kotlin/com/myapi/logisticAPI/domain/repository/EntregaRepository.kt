package com.myapi.logisticAPI.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import myapi.com.br.logisticAPI.domain.model.Entrega

@Repository
interface EntregaRepository : JpaRepository<Entrega, Long> {

}