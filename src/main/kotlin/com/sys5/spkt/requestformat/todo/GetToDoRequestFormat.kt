package com.sys5.spkt.requestformat.todo

import com.sys5.spkt.requestformat.BaseRequestFormat

data class GetToDoRequestFormat (
    var userId: Int = 0
) : BaseRequestFormat()