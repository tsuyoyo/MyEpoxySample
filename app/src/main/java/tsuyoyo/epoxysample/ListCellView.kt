package tsuyoyo.epoxysample

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp

@ModelView(autoLayout = ModelView.Size.WRAP_WIDTH_MATCH_HEIGHT)
class ListCellView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.view_list_cell, this)
    }

    private val image: ImageView
        get() = findViewById(R.id.image_view)

    private val colorName: TextView
        get() = findViewById(R.id.color_name)

    private val timeLabel: TextView
        get() = findViewById(R.id.time_label)


    @ModelProp
    fun setImageColor(color: Int) {
        image.setBackgroundColor(color)
    }

    @ModelProp
    fun setColorName(@ColorInt color: Int) {
        colorName.text = String.format("#%06X", (0xFFFFFF and color))
    }

    @TextProp
    fun setLabel(label: CharSequence) {
        timeLabel.text = label
    }
}