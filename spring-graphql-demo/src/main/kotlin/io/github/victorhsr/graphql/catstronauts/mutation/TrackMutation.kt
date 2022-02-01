package io.github.victorhsr.graphql.catstronauts.mutation

import io.github.victorhsr.graphql.catstronauts.TrackAPI
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller


@Controller
class TrackMutation(private val trackAPI: TrackAPI) {

    @MutationMapping
    suspend fun incrementTrackViews(@Argument id: String): IncrementTrackViewsResponse {
        val track = this.trackAPI.incrementTrackViews(id)
            ?: return IncrementTrackViewsResponse(code = HttpStatus.NOT_FOUND.value(),
                success = false,
                message = "Message not found",
                track = null)

        return return IncrementTrackViewsResponse(code = HttpStatus.OK.value(),
            success = true,
            message = "Successfully incremented number of views for track $id",
            track = track)
    }
}