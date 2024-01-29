package dev.duprat.legacytraining.common.ui

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.flexbox.FlexboxLayout
import dev.duprat.legacytraining.R

class TagList(context: Context, attrs: AttributeSet) : FlexboxLayout(context, attrs) {
    private var tagColor: Int

    init {
        context.theme.obtainStyledAttributes(attrs, R.styleable.TagList, 0, 0).apply {
            try {
                tagColor = getColor(R.styleable.TagList_tagColor, Color.GRAY)
            } finally {
                recycle()
            }
        }
        inflate(context, R.layout.tag_list_layout, this)
    }

    fun addTags(tags: List<String>) {
        tags.forEach { tag ->
            val tagView =
                LayoutInflater.from(context).inflate(R.layout.tag_layout, this, false) as TextView
            tagView.text = tag

            val background = ContextCompat.getDrawable(context, R.drawable.tag_background)
                ?.mutate() as GradientDrawable
            background.setColor(tagColor)
            tagView.background = background
            
            addView(tagView)
        }
    }
}