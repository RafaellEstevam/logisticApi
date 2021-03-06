package com.myapi.logisticAPI.domain.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Cliente(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    val nome: String,

    val email: String,

    val telefone: String
){
    constructor(id: Long) : this(id, "", "", "")
}