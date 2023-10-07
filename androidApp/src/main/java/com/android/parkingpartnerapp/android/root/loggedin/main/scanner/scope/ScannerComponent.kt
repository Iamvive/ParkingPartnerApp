package com.android.parkingpartnerapp.android.root.loggedin.main.scanner.scope

import dagger.Subcomponent

@ScannerScope
@Subcomponent(
    modules = [ScannerModule::class],
)
interface ScannerComponent {

}