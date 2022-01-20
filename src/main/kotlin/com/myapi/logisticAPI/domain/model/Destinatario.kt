package com.myapi.logisticAPI.domain.model

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class Destinatario(

    @Column(name = "dest_nome")
    val nome: String,

    @Column(name = "dest_logradouro")
    val logradouro: String,

    @Column(name = "dest_numero")
    val numero: String,

    @Column(name = "dest_complemento")
    val complemento: String,

    @Column(name = "dest_bairro")
    val bairro: String,

)