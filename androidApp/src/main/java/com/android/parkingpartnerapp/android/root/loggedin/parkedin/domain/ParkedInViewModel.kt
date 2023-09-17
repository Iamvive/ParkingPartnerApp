package com.android.parkingpartnerapp.android.root.loggedin.parkedin.domain

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ParkedInViewModel
@Inject constructor(
    val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    fun onScreenLoaded() {
    }
}