package com.greennile.rotas.controllers

import com.greennile.rotas.models.Rota
import com.greennile.rotas.repositories.RotaRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/rotas")
//() injeção da interface
class RotaController(private val rotaRepository: RotaRepository) {

    //post mapping é o metodo utilizado para criar
    @PostMapping
    fun new(@RequestBody novaRota: Rota): ResponseEntity<Rota>{
        //salva rota no bd
        rotaRepository.save(novaRota)
        return ResponseEntity.ok().body(novaRota)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): ResponseEntity<Optional<Rota>> {
        val rota = rotaRepository.findById(id)
        return if(rota.isPresent){
            ResponseEntity.ok().body(rota)
        }
        else{
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @GetMapping
    fun getAll() = ResponseEntity.ok().body(rotaRepository.findAll())

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteOne(@PathVariable id: Int){
        rotaRepository.deleteById(id)
    }


    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody novaRota: Rota): ResponseEntity<Rota>?{
        return rotaRepository.findById(id)
            .map { rota ->
                val novaVersaoRota = novaRota.copy(id = rota.id, paradas = rota.paradas)
                rotaRepository.save(novaVersaoRota)
                ResponseEntity.ok().body(novaVersaoRota)
            }.orElse(ResponseEntity(HttpStatus.NOT_FOUND))
    }

}