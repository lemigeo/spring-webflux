package com.remi.webflux.handler

import com.remi.webflux.data.ProjectData
import com.remi.webflux.domain.Project
import com.remi.webflux.service.ProjectService
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.bodyToMono
import reactor.core.publisher.Mono

@Component
class ProjectHandler(private val service: ProjectService) {

    fun get(request: ServerRequest) : Mono<ServerResponse> {
        val id = request.pathVariable("id")
        val project = service.get(id)
        return ServerResponse
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(project.defaultIfEmpty(Project()))
    }

    fun list(request: ServerRequest) : Mono<ServerResponse> {
        val projects = service.list()
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(projects)
    }

    fun create(request: ServerRequest) : Mono<ServerResponse> {
        val project = request.bodyToMono<ProjectData>()
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue({})
    }

    fun update(request: ServerRequest) : Mono<ServerResponse> {
        val project = request.bodyToMono<ProjectData>()
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue({})
    }
}