package com.android.parkingpartnerapp.root.loggedin.parkedin.view

import com.android.parkingpartnerapp.root.ui.models.Color

data class ParkedInVehicleData(
    val thumbnailData: ThumbnailData,
    val amountWithCurrencySymbol: String?,
    val vehicleNumber: String,
    val checkedInLabel: String,
    val dateAndTime: String,
)

data class ThumbnailData(
    val title: String,
    val color: Color,
)
