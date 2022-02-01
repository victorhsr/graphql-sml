package io.github.victorhsr.graphql.catstronauts.query

import io.github.victorhsr.graphql.catstronauts.Track
import io.github.victorhsr.graphql.catstronauts.TrackAPI
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class TrackDataFetcher(private val trackAPI: TrackAPI) {

    @QueryMapping
    suspend fun track(@Argument id: String): Track? {
        return this@TrackDataFetcher.trackAPI.getTrack(id)
    }

    @QueryMapping
    suspend fun tracksForHome(): List<Track> {
        return this.trackAPI.getTracks()
    }

}