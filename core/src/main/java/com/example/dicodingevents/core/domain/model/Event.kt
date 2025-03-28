package com.example.dicodingevents.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Event(
    val id: Int,
    val name: String,
    val summary: String,
    val mediaCover: String,
    val registrants: Int,
    val imageLogo: String,
    val link: String,
    val description: String,
    val ownerName: String,
    val cityName: String,
    val quota: Int,
    val beginTime: String,
    val endTime: String,
    val category: String,
    var isFavorite: Boolean = false
) : Parcelable