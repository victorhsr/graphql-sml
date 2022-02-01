package io.github.victorhsr.graphql.catstronauts

/**
 * This class maps the Track from the catstronauts API, so it's structure is
 * slight different from the one defined in our the graphql schema
 */
data class Track(
    val id: String,
    val title: String,
    val authorId: String,
    val thumbnail: String? = null,
    val length: Int? = null,
    val modulesCount: Int? = null,
    val description: String? = null,
    val numberOfViews: Int,
    val modules: List<String>,
)