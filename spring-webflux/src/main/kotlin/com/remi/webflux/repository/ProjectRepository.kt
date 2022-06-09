package com.remi.webflux.repository

import com.remi.webflux.domain.Project
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface ProjectRepository : R2dbcRepository<Project, String> {
    fun findTop1ById(id: String): Mono<Project>
}