package com.android.parkingpartnerapp.root.localization

import com.android.parkingpartnerapp.root.localization.Locale.English
import com.android.parkingpartnerapp.root.localization.Locale.Hindi

sealed class Locale {
    object Hindi : Locale()
    object English : Locale()
}

fun Locale.toStringFormat(stringRes: StringRes) =
    when (this) {
        English -> stringRes.englishRes
        Hindi -> stringRes.hindiRes
    }
