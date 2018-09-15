package com.sys5.spkt.requestformat.todo

import com.sys5.spkt.requestformat.BaseRequestFormat

data class AddToDoRequestFormat(

    var userId: Int = 0,
    var text: String = ""

) : BaseRequestFormat()