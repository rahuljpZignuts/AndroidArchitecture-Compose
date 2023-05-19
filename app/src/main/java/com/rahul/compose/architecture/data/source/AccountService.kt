package com.rahul.compose.architecture.data.source

import com.rahul.compose.architecture.data.model.Public
import com.rahul.compose.architecture.network.WebService
import com.rahul.compose.architecture.network.meta.NoAuth
import retrofit2.Call
import retrofit2.http.GET

/**
 * Account service api interface for all account related api calls
 */
interface AccountService : WebService {

    @GET("/random")
    @NoAuth
    fun login(): Call<Public>

    @GET("/entries")
    fun getEntries() : Call<Public>
}
