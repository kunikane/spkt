package com.sys5.spkt.requestformat.user

import com.sys5.spkt.requestformat.BaseRequestFormat

data class AddUserRequestFormat(

    var id: Int = -1,
    var name: String = "",
    var email: String = "",
    var password: String = ""

) : BaseRequestFormat()