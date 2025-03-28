package com.example.dicodingevents.detail

import androidx.lifecycle.ViewModel
import com.example.dicodingevents.core.domain.model.Event
import com.example.dicodingevents.core.domain.usecase.EventUseCase

class DetailEventViewModel(private val eventUseCase: EventUseCase) : ViewModel() {
    fun setFavoriteEvent(event: Event, newStatus:Boolean) =
        eventUseCase.setFavoriteEvent(event, newStatus)
}

