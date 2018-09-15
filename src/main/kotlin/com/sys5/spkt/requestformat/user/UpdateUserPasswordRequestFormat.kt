package com.sys5.spkt.requestformat.user

import com.sys5.spkt.requestformat.BaseRequestFormat

data class UpdateUserPasswordRequestFormat (

    var id: Int = -1,
    var password: String = ""

) : BaseRequestFormat()