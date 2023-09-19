package com.android.parkingpartnerapp.repo

import com.android.parkingpartnerapp.repo.Status.FAILED
import com.android.parkingpartnerapp.repo.Status.LIVE
import com.android.parkingpartnerapp.repo.Status.LOADING
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class SimpleRepo<DomainModel> : Repo<DomainModel> {
    private val statusFlow = MutableStateFlow(LOADING)
    private val valuesFlow: MutableStateFlow<DomainModel?> = MutableStateFlow(null)

    suspend fun update(apiJob: () -> DomainModel) {
        try {
            statusFlow.value = LOADING
            val model = apiJob.invoke()
            valuesFlow.value = model
            statusFlow.value = LIVE
        } catch (e: Exception) {
            statusFlow.value = FAILED
            e.message
        }
    }

    suspend fun <ResponseModel> updateWithValue(
        apiJob: () -> ResponseModel,
        mapper: (ResponseModel) -> DomainModel,
    ): DomainModel? {
        return try {
            statusFlow.value = LOADING
            val responseModel = apiJob.invoke()
            val model: DomainModel = mapper.invoke(responseModel)
            valuesFlow.value = model
            statusFlow.value = LIVE
            model
        } catch (e: Exception) {
            statusFlow.value = FAILED
            e.message
            return null
        }
    }

    override val lastValue: DomainModel?
        get() = valuesFlow.value
    override val lastStatus: Status
        get() = statusFlow.value
    override val valueStream: Flow<DomainModel?>
        get() = valuesFlow
    override val statusStream: Flow<Status>
        get() = statusFlow
}