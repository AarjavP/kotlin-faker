package io.github.serpro69.kfaker.provider

import io.github.serpro69.kfaker.*
import io.github.serpro69.kfaker.dictionary.*

/**
 * [FakeDataProvider] implementation for [CategoryName.COFFEE] category.
 */
class Coffee internal constructor(fakerService: FakerService) : AbstractFakeDataProvider(fakerService) {
    override val categoryName = CategoryName.COFFEE

    val country = resolve { fakerService.resolve(Faker, it, "country") }
    val regions: (country: String) -> String = { country ->
        resolve { fakerService.resolve(Faker, it, "regions", country) }.invoke()
        // TODO: 3/22/2019 ignore case for country?
    }
    val variety = resolve { fakerService.resolve(Faker, it, "variety") }
    val notes = resolve { fakerService.resolve(Faker, it, "notes") }
    val blendName = resolve { fakerService.resolve(Faker, it, "blend_name") }
}