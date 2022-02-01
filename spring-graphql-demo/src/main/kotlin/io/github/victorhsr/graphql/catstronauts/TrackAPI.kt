package io.github.victorhsr.graphql.catstronauts

import io.github.victorhsr.graphql.catstronauts.author.Author
import io.github.victorhsr.graphql.catstronauts.module.Module
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitEntity
import org.springframework.web.reactive.function.client.awaitExchange

@Component
class TrackAPI(@Value("\${external.api.track.location}") private val baseUrl: String) {

    private val webClient: WebClient = WebClient.create(this.baseUrl)

    suspend fun getTrack(trackId: String?): Track? {

        val responseEntity = webClient.get().uri("/track/${trackId}")
            .awaitExchange { clientResponse -> clientResponse.awaitEntity(Track::class) }

        if (responseEntity.statusCode == HttpStatus.NOT_FOUND) return null

        return responseEntity.body
    }

    suspend fun getModules(trackId: String): List<Module> {
        val responseEntity = this.webClient.get().uri("/track/${trackId}/modules")
            .awaitExchange { clientResponse -> clientResponse.awaitEntity(Array<Module>::class) }

        if (responseEntity.statusCode == HttpStatus.NOT_FOUND) return emptyList()

        return responseEntity.body!!.toList()
    }

    suspend fun getAuthor(authorId: String): Author? {
        val responseEntity = this.webClient.get().uri("/author/${authorId}")
            .awaitExchange { clientResponse -> clientResponse.awaitEntity(Author::class) }

        if (responseEntity.statusCode == HttpStatus.NOT_FOUND) return null

        return responseEntity.body
    }

    suspend fun getTracks(): List<Track> {
        return this.webClient.get().uri("/tracks")
            .awaitExchange { clientResponse -> clientResponse.awaitEntity(Array<Track>::class) }
            .body!!
            .toList()
    }

    suspend fun getModule(moduleId: String): Module {
        return this.webClient.get().uri("/module/${moduleId}")
            .awaitExchange { clientResponse -> clientResponse.awaitEntity(Module::class) }
            .body!!
    }

    suspend fun incrementTrackViews(trackId: String): Track? {
        val responseEntity = this.webClient.patch().uri("/track/${trackId}/numberOfViews")
            .awaitExchange { clientResponse -> clientResponse.awaitEntity(Track::class) }

        if (responseEntity.statusCode == HttpStatus.NOT_FOUND) return null

        return responseEntity.body
    }
}