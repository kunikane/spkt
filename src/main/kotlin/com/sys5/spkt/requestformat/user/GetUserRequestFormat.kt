package com.sys5.spkt.requestformat.user

import com.sys5.spkt.requestformat.BaseRequestFormat

data class GetUserRequestFormat (

    var id: Int = -1

) : BaseRequestFormat()