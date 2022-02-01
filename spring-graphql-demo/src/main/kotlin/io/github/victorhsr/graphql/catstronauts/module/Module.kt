package io.github.victorhsr.graphql.catstronauts.module

data class Module(
    val id: String,
    val title: String,
    val length: Int? = null,
    val content: String? = null,
    val videoUrl: String? = null,
)