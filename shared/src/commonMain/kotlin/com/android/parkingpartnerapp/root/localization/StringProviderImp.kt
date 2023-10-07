package com.android.parkingpartnerapp.root.localization

class StringProviderImp(
    private val locale: Locale,
) : StringProvider {
    override fun invoke(
        stringRes: StringRes,
        vararg formatArgs: String,
    ): String {
        val stringFormat = locale.toStringFormat(stringRes)
        return formatArgs.foldIndexed(stringFormat) { index, acc, s ->
            val argKey = "#args${index + 1}"
            acc.replace(argKey, s)
        }
    }
}
