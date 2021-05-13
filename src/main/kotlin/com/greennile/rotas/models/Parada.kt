package com.greennile.rotas.models

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
data class Parada(
    @Id
    @GeneratedValue
    val id: Int? = null,
    val nomeCLiente: String? = null,
    val endereco: String? = null,

    //para muitas paradas, há uma rota
    @ManyToOne(fetch = FetchType.LAZY)  //fetch lazy faz com que a rota não seja trazida automaticamente
    @JoinColumn(name = "rota_id", nullable = false)     //define o nome da coluna que parada vai usar
    @JsonBackReference //Evita exibir rotas nulas
    val rota: Rota = Rota()
)