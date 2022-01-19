package com.myapi.logisticAPI.domain.model

import java.time.OffsetDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
data class Ocorrencia(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    val descricao: String,

    @Column(name = "data_registro")
    var dataRegistro: OffsetDateTime?,

    @ManyToOne
    var entrega: Entrega?
)
