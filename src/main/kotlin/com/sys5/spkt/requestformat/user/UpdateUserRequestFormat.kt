package com.sys5.spkt.requestformat.user

import com.sys5.spkt.requestformat.BaseRequestFormat

data class UpdateUserRequestFormat (

    var id: Int = -1,
    var name: String = "",
    var email: String = ""

) : BaseRequestFormat()