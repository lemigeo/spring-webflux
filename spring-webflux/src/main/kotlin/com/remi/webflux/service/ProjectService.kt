package com.remi.webflux.service

import com.remi.webflux.domain.Project
import com.remi.webflux.repository.ProjectRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class ProjectService(private val repository: ProjectRepository) {
    fun get(id: String): Mono<Project> {
        return repository.findTop1ById(id)
    }

    fun list(): Flux<Project> {
        return repository.findAll()
    }
}