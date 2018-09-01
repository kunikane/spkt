package com.sys5.spkt.responseformat.todo

import com.sys5.spkt.responseformat.BaseResponseFormat

data class UpdateToDoCompleteFlagResponseFormat (
    var result: String
) : BaseResponseFormat()