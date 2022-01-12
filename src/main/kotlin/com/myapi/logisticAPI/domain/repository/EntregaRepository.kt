package com.myapi.logisticAPI.domain.repository

import com.myapi.logisticAPI.domain.model.Entrega
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface EntregaRepository : JpaRepository<Entrega, Long> {

}