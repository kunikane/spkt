package com.sys5.spkt.responseformat.user

import com.sys5.spkt.entity.User
import com.sys5.spkt.responseformat.BaseResponseFormat

data class UpdateUserPasswordResponseFormat (
    var user: User
) : BaseResponseFormat()