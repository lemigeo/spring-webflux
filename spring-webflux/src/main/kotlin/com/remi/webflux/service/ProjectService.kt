package com.remi.webflux.service

import com.remi.webflux.domain.Account
import com.remi.webflux.domain.Project
import com.remi.webflux.repository.ProjectRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class ProjectService(private val repo: ProjectRepository) {
    fun get(id: String): Mono<Project> {
        return repo.findById(id)
    }

    fun list(): Flux<Project> {
        return repo.findAll()
    }

    fun add(project: Project): Mono<Project> {
        return repo.save(project)
    }

    fun update(project: Project): Mono<Project> {
        return repo.findById(project.id!!).flatMap {
            it.name = project.name
            repo.save(it)
        }
    }
}