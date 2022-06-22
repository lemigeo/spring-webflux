package com.remi.webflux.service

import com.remi.webflux.domain.Account
import com.remi.webflux.repository.AccountRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class AccountService(private val repo: AccountRepository) {
    fun get(id: String): Mono<Account> {
        return repo.findById(id)
    }

    fun list(): Flux<Account> {
        return repo.findAll()
    }

    fun add(account: Account): Mono<Account> {
        return repo.save(account)
    }

    fun update(account: Account): Mono<Account> {
        return repo.findById(account.id!!).flatMap {
            it.name = account.name
            repo.save(it)
        }
    }
}