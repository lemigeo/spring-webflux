package com.remi.webflux.controller

import com.remi.webflux.data.AccountData
import com.remi.webflux.domain.Account
import com.remi.webflux.service.AccountService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class AccountController(private val service: AccountService) {

    @GetMapping("/account/{id}", produces = ["application/json"])
    @ResponseBody
    fun get(@PathVariable id: String): Mono<Account> {
        return service.get(id)
    }

    @GetMapping("/account", produces = ["application/json"])
    @ResponseBody
    fun get(): Flux<Account> {
        return service.list()
    }

    @PostMapping("/account", consumes = ["application/json"])
    @ResponseStatus(HttpStatus.CREATED)
    fun post(@RequestBody account: AccountData) {
        println(account)
    }
}