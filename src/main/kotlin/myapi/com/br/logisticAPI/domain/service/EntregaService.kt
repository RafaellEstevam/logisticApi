package myapi.com.br.logisticAPI.domain.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.util.StringUtils
import myapi.com.br.logisticAPI.domain.exception.BusinessException
import myapi.com.br.logisticAPI.domain.model.Entrega
import myapi.com.br.logisticAPI.domain.model.StatusEntrega
import myapi.com.br.logisticAPI.domain.repository.ClienteRepository
import myapi.com.br.logisticAPI.domain.repository.EntregaRepository
import java.time.OffsetDateTime

@Service
class EntregaService(val entregaRepository: EntregaRepository, val clienteRepository: ClienteRepository) {

    @Transactional
    fun registrar(entrega: Entrega): Entrega {

        if(!StringUtils.isEmpty(entrega.id)){

            val entregaOptional = entregaRepository.findById(entrega.id!!);

            if(!entregaOptional.isPresent){
                throw BusinessException("Entrega não encontrada!");
            }

            entrega.status = entregaOptional.get().status;
            entrega.dataPedido = entregaOptional.get().dataPedido;

        }else{
            entrega.status = StatusEntrega.PENDENTE;
            entrega.dataPedido = OffsetDateTime.now();
        }


        val clienteOptional = clienteRepository.findById(entrega.cliente.id);


        if(!clienteOptional.isPresent){
            throw BusinessException("Cliente não encontrado!");
        }

        entrega.cliente = clienteOptional.get();


         entregaRepository.save(entrega);

        return entrega;

    }


}