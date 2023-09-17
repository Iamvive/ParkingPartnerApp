package com.android.parkingpartnerapp.root.localization

interface StringProvider {
    operator fun invoke(stringRes: StringRes, vararg formatArgs: String): String
}