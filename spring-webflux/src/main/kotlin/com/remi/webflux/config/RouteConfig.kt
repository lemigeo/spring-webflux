package com.remi.webflux.config

import com.remi.webflux.handler.ProjectHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RequestPredicates.accept
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse

@Configuration
class RouteConfig {

    @Bean
    fun routeProject(handler: ProjectHandler): RouterFunction<ServerResponse> {
        return RouterFunctions.route()
            .path("/project") { builder ->
                builder
                    .GET("/{id}") { request -> handler.get(request) }
                    .GET("") { request -> handler.list(request) }
                    .nest(accept(MediaType.APPLICATION_JSON)) { jsonBuilder ->
                        jsonBuilder
                            .POST("", accept(MediaType.APPLICATION_JSON), handler::create)
                            .PUT("", accept(MediaType.APPLICATION_JSON), handler::update)
                    }
            }.build()
    }
}