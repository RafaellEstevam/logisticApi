package com.myapi.logisticAPI.api.exceptionHandler

import com.myapi.logisticAPI.domain.exception.BusinessException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.OffsetDateTime

@ControllerAdvice
class ApiExceptionHandler : ResponseEntityExceptionHandler() {


    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {


        val dataHora = OffsetDateTime.now();
        val descricao = "Um ou mais campos estão inválidos!"
        val atributos = ArrayList<Atributo>();

        val objectErrors = ex.bindingResult.allErrors;

        for (error in objectErrors) {

            error as FieldError;
            val nome = error.field;
            val mensagem = error.defaultMessage;

            val atributo = Atributo(nome, mensagem);

            atributos.add(atributo);
        }

        val exceptionResponseBody = ExceptionResponseBody(status.value(), dataHora, descricao, atributos);

        return handleExceptionInternal(ex, exceptionResponseBody, headers, status, request);

    }

    @ExceptionHandler(BusinessException::class)
    fun handleBusinessException(ex: BusinessException, request: WebRequest): ResponseEntity<Any> {

        val status = HttpStatus.BAD_REQUEST;
        val dataHora = OffsetDateTime.now();
        val descricao = ex.message;

        val exceptionResponseBody = ExceptionResponseBody(status.value(), dataHora, descricao);

        return handleExceptionInternal(ex, exceptionResponseBody, HttpHeaders(), status, request);

    }


}