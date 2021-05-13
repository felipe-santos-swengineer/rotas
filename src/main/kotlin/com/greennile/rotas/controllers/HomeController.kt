package com.greennile.rotas.controllers
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

//anotação spring para ele entender que é um controler
@RestController
@RequestMapping("/")
class HomeController {

    //tem que explicitar o metodo rest
    @GetMapping
    fun hello():String{
        return "Spring com Kotlin para web"
    }
}

