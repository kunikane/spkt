package com.sys5.spkt.requestformat.todo

import com.sys5.spkt.requestformat.BaseRequestFormat

data class UpdateToDoTextRequestFormat (

    var text: String = ""

) : BaseRequestFormat()