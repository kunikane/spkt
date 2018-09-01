package com.sys5.spkt.responseformat.todo

import com.sys5.spkt.responseformat.BaseResponseFormat

data class DeleteToDoResponseFormat (
    var result: String
) : BaseResponseFormat()