package myapi.com.br.logisticAPI.api.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import myapi.com.br.logisticAPI.domain.model.Cliente
import myapi.com.br.logisticAPI.domain.repository.ClienteRepository
import myapi.com.br.logisticAPI.domain.service.ClienteService

@RestController
@RequestMapping("clientes")
class ClienteController(private val clienteRepository: ClienteRepository, private val clienteService: ClienteService) {

    @GetMapping
    fun listar(): List<Cliente> {
        return clienteRepository.findAll()
    }

    @GetMapping("{clienteId}")
    fun buscar(@PathVariable clienteId: Long): ResponseEntity<Cliente> {
        return clienteRepository.findById(clienteId)
            .map { cliente -> ResponseEntity.ok(cliente) }
            .orElse(ResponseEntity.notFound().build())
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun salvar(@RequestBody cliente: Cliente): Cliente {
        return clienteService.salvar(cliente)
    }

    @PutMapping("{clienteId}")
    fun atualizar(@PathVariable clienteId: Long, @RequestBody cliente: Cliente): ResponseEntity<Cliente> {

        if (!clienteRepository.existsById(clienteId)) {
            return ResponseEntity.notFound().build()
        }

        cliente.id = clienteId
        return ResponseEntity.ok(clienteService.salvar(cliente));
    }
}