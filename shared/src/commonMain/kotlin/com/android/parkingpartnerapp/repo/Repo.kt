package com.android.parkingpartnerapp.repo

import kotlinx.coroutines.flow.Flow

interface Repo<DomainModel> {
    val lastValue: DomainModel?
    val lastStatus: Status

    val valueStream: Flow<DomainModel?>
    val statusStream: Flow<Status>
}
