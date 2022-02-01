package io.github.victorhsr.graphql.catstronauts.query

import io.github.victorhsr.graphql.catstronauts.Track
import io.github.victorhsr.graphql.catstronauts.TrackAPI
import io.github.victorhsr.graphql.catstronauts.author.Author
import io.github.victorhsr.graphql.catstronauts.module.Module
import org.springframework.graphql.data.method.annotation.SchemaMapping
import org.springframework.stereotype.Controller

@Controller
class TrackSchemaMapping(private val trackAPI: TrackAPI) {

    @SchemaMapping(typeName = "Track", field = "modules")
    suspend fun modules(track: Track): List<Module> {
        return this.trackAPI.getModules(track.id)
    }

    @SchemaMapping(typeName = "Track", field = "author")
    suspend fun author(track: Track): Author? {
        return this.trackAPI.getAuthor(track.authorId)
    }
}