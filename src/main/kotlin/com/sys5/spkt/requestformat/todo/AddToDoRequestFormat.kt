package com.sys5.spkt.requestformat.todo

import com.sys5.spkt.requestformat.BaseRequestFormat

data class AddToDoRequestFormat(

    /** ユーザID */
    var userId: Int = 0,

    /** TODOテキスト */
    var text: String = ""
) : BaseRequestFormat()