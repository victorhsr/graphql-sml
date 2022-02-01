package io.github.victorhsr.graphql.catstronauts.module.query

import io.github.victorhsr.graphql.catstronauts.TrackAPI
import io.github.victorhsr.graphql.catstronauts.module.Module
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class ModuleDataFetcher(private val trackAPI: TrackAPI) {

    @QueryMapping
    suspend fun module(@Argument id: String): Module {
        return this.trackAPI.getModule(id)
    }

}