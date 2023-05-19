package com.rahul.compose.architecture.data.source

import com.rahul.compose.architecture.data.model.Public
import com.rahul.compose.architecture.injection.DataSourceDispatcher
import com.rahul.compose.architecture.network.NetworkExecutor
import com.rahul.compose.architecture.network.meta.DataRequest
import com.rahul.compose.architecture.network.meta.DataResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Data source to handle network updates for operations related with account actions.
 */
@Singleton
class AccountRemoteSource @Inject constructor(
    @DataSourceDispatcher private val dispatcher: CoroutineDispatcher,
    private val networkExecutor: NetworkExecutor<AccountService>,
) {
    suspend fun login(): DataResponse<Public> =
        withContext(dispatcher) {
            return@withContext networkExecutor.execute(DataRequest) {
                login()
            }
        }

    suspend fun getEntries() : DataResponse<Public> =
        withContext(dispatcher){
            return@withContext networkExecutor.execute(DataRequest) {
                getEntries()
            }
        }
}
