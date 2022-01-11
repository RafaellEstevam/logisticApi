package com.myapi.logisticAPI.domain.model

import java.math.BigDecimal
import java.time.OffsetDateTime
import javax.persistence.*

@Entity
data class Entrega(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    val taxa: BigDecimal,

    var dataPedido: OffsetDateTime?,

    var dataFinalizacao: OffsetDateTime? = null,

    @Enumerated(EnumType.STRING)
    var status: StatusEntrega?,

    @ManyToOne
    var cliente: Cliente,

    @Embedded
    val destinatario: Destinatario

)