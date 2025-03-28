package com.example.dicodingevents.core.domain.usecase

import com.example.dicodingevents.core.data.Resource
import com.example.dicodingevents.core.domain.model.Event
import com.example.dicodingevents.core.domain.repository.IEventRepository
import kotlinx.coroutines.flow.Flow

class EventInteractor(private val eventRepository: IEventRepository) : EventUseCase {
    override fun getAllEvent(): Flow<Resource<List<Event>>> {
        return eventRepository.getAllEvent()
    }

    override fun getFavoriteEvent(): Flow<List<Event>> {
        return eventRepository.getFavoriteEvent()

    }

    override fun setFavoriteEvent(event: Event, state: Boolean) {
        eventRepository.setFavoriteEvent(event, state)
    }
}