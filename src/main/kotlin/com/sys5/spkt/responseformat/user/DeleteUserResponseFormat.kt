package com.sys5.spkt.responseformat.user

import com.sys5.spkt.responseformat.BaseResponseFormat

data class DeleteUserResponseFormat (
    var result: String
) : BaseResponseFormat()