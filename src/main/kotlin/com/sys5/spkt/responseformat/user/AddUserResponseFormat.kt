package com.sys5.spkt.responseformat.user

import com.sys5.spkt.entity.ToDo
import com.sys5.spkt.responseformat.BaseResponseFormat

data class AddUserResponseFormat (
    var todo: ToDo
) : BaseResponseFormat()