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
        return projects.hasElements().flatMap {
            if(it) {
                ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(projects)
            }
            else {
                ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(Mono.just(ArrayList<Project>()))
            }
        }
    }

    fun create(request: ServerRequest) : Mono<ServerResponse> {
        val project = request.bodyToMono<Project>()
        val result = project.flatMap {
            service.add(it)
        }
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(result)
    }

    fun update(request: ServerRequest) : Mono<ServerResponse> {
        val project = request.bodyToMono<Project>()
        val result = project.flatMap {
            service.update(it)
        }
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(result)
    }
}