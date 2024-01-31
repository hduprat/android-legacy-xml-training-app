package dev.duprat.legacytraining.common.ui

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import com.google.android.flexbox.FlexboxLayout
import dev.duprat.legacytraining.R
import dev.duprat.legacytraining.databinding.TagLayoutBinding
import dev.duprat.legacytraining.databinding.TagListLayoutBinding

class TagList(context: Context, attrs: AttributeSet) : FlexboxLayout(context, attrs) {
    private var tagColor: Int
    private val binding = TagListLayoutBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        context.theme.obtainStyledAttributes(attrs, R.styleable.TagList, 0, 0).apply {
            try {
                tagColor = getColor(R.styleable.TagList_tagColor, Color.GRAY)
            } finally {
                recycle()
            }
        }
    }

    fun setTags(tags: List<String>) {
        binding.tagList.removeAllViews()
        val tagsSet = tags.toSet()
        tagsSet.forEach { tag ->
            val tagView = TagLayoutBinding.inflate(LayoutInflater.from(context), this, false).root
            tagView.text = tag

            val background = ContextCompat.getDrawable(context, R.drawable.tag_background)
                ?.mutate() as GradientDrawable
            background.setColor(tagColor)
            tagView.background = background

            val layoutParams = tagView.layoutParams as LayoutParams
            layoutParams.marginEnd = 8

            binding.tagList.addView(tagView)
        }
    }
}