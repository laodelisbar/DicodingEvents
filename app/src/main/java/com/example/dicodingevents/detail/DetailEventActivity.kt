package com.example.dicodingevents.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.IntentCompat.getParcelableExtra
import androidx.core.text.HtmlCompat
import com.bumptech.glide.Glide
import com.example.dicodingevents.R
import com.example.dicodingevents.core.domain.model.Event
import com.example.dicodingevents.databinding.ActivityDetailEventBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailEventActivity : AppCompatActivity() {

    private val detailEventViewModel: DetailEventViewModel by viewModel()
    private lateinit var binding: ActivityDetailEventBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailEventBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val detailEvent = getParcelableExtra(intent, EXTRA_DATA, Event::class.java)
        showDetailTourism(detailEvent)
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_favorite_white
                )
            )
        } else {
            binding.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_not_favorite_white
                )
            )
        }
    }

    private fun showDetailTourism(detailEvent: Event?) {
        detailEvent?.let {
            val description = detailEvent.description
            binding.tvNameEvent.text = detailEvent.name
            binding.contentDetailEvent.tvDetailDescription.text = getString(
                R.string.event_description_format,
                getString(R.string.event_description),
                HtmlCompat.fromHtml(description, HtmlCompat.FROM_HTML_MODE_LEGACY)
            )
            Glide.with(this@DetailEventActivity)
                .load(detailEvent.mediaCover)
                .into(binding.ivDetailImage)

            var statusFavorite = detailEvent.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailEventViewModel.setFavoriteEvent(detailEvent, statusFavorite)
                setStatusFavorite(statusFavorite)

            }
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}
