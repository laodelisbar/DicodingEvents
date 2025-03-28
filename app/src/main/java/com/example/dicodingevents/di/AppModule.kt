package com.example.dicodingevents.di

import com.example.dicodingevents.core.domain.usecase.EventInteractor
import com.example.dicodingevents.core.domain.usecase.EventUseCase
import com.example.dicodingevents.detail.DetailEventViewModel
import com.example.dicodingevents.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<EventUseCase> { EventInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailEventViewModel(get()) }
}