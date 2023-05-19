package com.rahul.compose.architecture.data.parser

import com.rahul.compose.architecture.data.model.auth.UserAuthResponse
import com.rahul.compose.architecture.data.proto.AuthUser
import com.rahul.compose.architecture.data.proto.Authentication
import javax.inject.Inject

/**
 * User response mapper to transform [UserAuthResponse] to [AuthUser]. This class takes responsibility
 * of mapping [UserAuthResponse] to [AuthUser], so any change in either class should reflect the
 * updates here to keep them consistent.
 */
class AuthenticationResponseMapper @Inject constructor() :
    ResourceMapper<UserAuthResponse, Authentication.Builder> {
    override fun map(
        response: UserAuthResponse?,
        cachedValue: Authentication.Builder?,
    ): Authentication.Builder? {
        if (response == null) return null
        val authentication = cachedValue ?: Authentication.getDefaultInstance().toBuilder()
        return authentication.apply {
            accessToken = response.accessToken
            build()
        }
    }
}
