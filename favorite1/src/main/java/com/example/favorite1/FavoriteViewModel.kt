package com.example.favorite1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.dicodingevents.core.domain.usecase.EventUseCase

class FavoriteViewModel(event: EventUseCase) : ViewModel() {
    val favoriteEvent = event.getFavoriteEvent().asLiveData()
}

