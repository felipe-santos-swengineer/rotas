package com.greennile.rotas.repositories

import com.greennile.rotas.models.Rota
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

//importar a interface jpa passando a classe e o tipo do id

@Repository
interface RotaRepository: JpaRepository<Rota,Int> {

}