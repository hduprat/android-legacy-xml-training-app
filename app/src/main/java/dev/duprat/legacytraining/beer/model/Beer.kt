package dev.duprat.legacytraining.beer.model

data class Beer(
    val name: String,
    val tagline: String,
    val description: String,
    val imageUrl: String,
    val hops: List<String>
)