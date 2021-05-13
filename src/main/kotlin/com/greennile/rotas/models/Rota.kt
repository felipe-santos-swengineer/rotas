package com.greennile.rotas.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity //Define que a classe é uma tabela e as variaveis colunas
//data class evitar ter que criar getters e setters
data class Rota(
    @Id  //@id diz que a chave primaria é a proxima var criada e que ele é autogeara e gerenciada pelo hibernate
    @GeneratedValue
    val id: Int? = null,
    val name: String? = null,
    @OneToMany(mappedBy = "rota")   //dentro dos parenteses fica a que sem refere
    val paradas: List<Parada> = emptyList()
)