@file:Suppress("PropertyName")

package dev.duprat.legacytraining.beer.model

data class BeerDto(
    val id: Int,
    val name: String,
    val tagline: String,
    val description: String,
    val image_url: String,
    val ingredients: IngredientsDto,
    val abv: Double,
    val ibu: Double,
)
