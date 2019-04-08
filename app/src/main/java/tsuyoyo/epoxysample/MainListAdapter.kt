package tsuyoyo.epoxysample

import android.graphics.Color
import com.airbnb.epoxy.CarouselModel_
import com.airbnb.epoxy.EpoxyController
import kotlin.random.Random

class MainListAdapter : EpoxyController() {

    override fun buildModels() {
        CarouselBoundaryViewModel_()
            .id("border-1")
            .title("----- 1 ------")
            .addTo(this)

        CarouselModel_()
            .id("Carousel-1")
            .models(buildModelsInCarousel(10, "Row1"))
            .addTo(this)

        CarouselBoundaryViewModel_()
            .id("border-2")
            .title("----- 2 ------")
            .addTo(this)

        CarouselModel_()
            .id("Carousel-2")
            .models(buildModelsInCarousel(3, "Row2"))
            .addTo(this)
    }

    private fun buildModelsInCarousel(num: Int, idBase: String): List<ListCellViewModel_> {
        val models = mutableListOf<ListCellViewModel_>()
        for (i in 1 .. num) {
            val randomColor = generateRandomColor()
            models.add(ListCellViewModel_()
                .id("row$idBase-$i")
                .colorName(randomColor)
                .imageColor(randomColor)
                .label(i.toString())
            )
        }
        return models
    }

    private fun generateRandomColor() =
        Random(System.nanoTime()).let {
            Color.argb(0f, it.nextFloat(), it.nextFloat(), it.nextFloat())
        }
}