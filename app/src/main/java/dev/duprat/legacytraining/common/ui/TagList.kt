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
import dev.duprat.legacytraining.databinding.TagLayoutBinding
import dev.duprat.legacytraining.databinding.TagListLayoutBinding

const val MAX_TAGS = 5

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
        tagsSet.take(MAX_TAGS).forEach { tag ->
            val tagView = generateTagView(tag)
            binding.tagList.addView(tagView)
        }
        if (tagsSet.size > MAX_TAGS) {
            val tagView = generateTagView("+${tagsSet.size - MAX_TAGS}")
            binding.tagList.addView(tagView)
        }
    }

    private fun generateTagView(tag: String): TextView {
        val tagView = TagLayoutBinding.inflate(LayoutInflater.from(context), this, false).root
        tagView.text = tag

        val background = ContextCompat.getDrawable(context, R.drawable.tag_background)
            ?.mutate() as GradientDrawable
        background.setColor(tagColor)
        tagView.background = background

        val layoutParams = tagView.layoutParams as LayoutParams
        layoutParams.marginEnd = 8

        return tagView
    }


}