package com.myapi.logisticAPI.api.exceptionHandler

import com.fasterxml.jackson.annotation.JsonInclude
import java.time.OffsetDateTime

@JsonInclude(JsonInclude.Include.NON_NULL)
class ExceptionResponseBody(

  val status: Int,

  val dataHora: OffsetDateTime,

  val descricao: String?,

  val atributos: List<Atributo>?


){
  constructor(status: Int, dataHora: OffsetDateTime, descricao: String?,): this(status, dataHora, descricao,null);
}