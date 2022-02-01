package io.github.victorhsr.graphql.catstronauts.mutation

import io.github.victorhsr.graphql.catstronauts.Track

data class IncrementTrackViewsResponse(val code: Int, val success: Boolean, val message: String, val track: Track?)