package dev.duprat.legacytraining.beer.model

class BeerDtoAdapter {
    companion object {
        fun toDomain(dto:BeerDto):Beer = Beer(
            name = dto.name,
            description = dto.description,
            imageUrl = dto.image_url,
            tagline = dto.tagline,
            malts = dto.ingredients.malt.map { it.name },
            hops = dto.ingredients.hops.map { it.name },
        )
    }
}