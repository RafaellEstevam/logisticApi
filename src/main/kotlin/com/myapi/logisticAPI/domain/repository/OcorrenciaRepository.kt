package com.myapi.logisticAPI.domain.repository

import com.myapi.logisticAPI.domain.model.Ocorrencia
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OcorrenciaRepository : JpaRepository<Ocorrencia, Long> {
}