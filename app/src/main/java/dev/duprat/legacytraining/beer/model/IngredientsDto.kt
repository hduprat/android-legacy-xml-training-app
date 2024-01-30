package dev.duprat.legacytraining.beer.model

data class IngredientsDto(
    val malt: List<MaltDto>,
    val hops: List<HopDto>,
    val yeast: String,
)
