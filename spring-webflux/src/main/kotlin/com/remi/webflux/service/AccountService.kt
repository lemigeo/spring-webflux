package com.remi.webflux.service

import com.remi.webflux.domain.Account
import com.remi.webflux.repository.AccountRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class AccountService(private val repository: AccountRepository) {
    fun get(id: String): Mono<Account> {
        return repository.findById(id)
    }

    fun list(): Flux<Account> {
        return repository.findAll()
    }
}