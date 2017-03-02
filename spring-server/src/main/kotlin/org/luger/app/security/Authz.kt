package org.luger.app.security

import org.springframework.stereotype.Component

/**
 * Created by gerardo8.
 */
@Component
class Authz {

    fun check(userId: Long?, userDetails: UserDetailsImpl) = userId == userDetails.user.id
}