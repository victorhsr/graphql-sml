package io.github.victorhsr.graphql

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.config.CorsRegistry
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.config.WebFluxConfigurer

@SpringBootApplication
class GraphqlDemoApplication

fun main(args: Array<String>) {
    runApplication<GraphqlDemoApplication>(*args)
}

@Configuration
@EnableWebFlux
class CORSGlobalConfiguration : WebFluxConfigurer {

    override fun addCorsMappings(corsRegistry: CorsRegistry) {
        corsRegistry.addMapping("/graphql")
            .allowedOrigins("http://localhost:3000")
            .allowedMethods("GET", "POST", "PATCH")
            .maxAge(3600)
    }

}

