package com.sys5.spkt.responseformat.todo

import com.sys5.spkt.entity.ToDo
import com.sys5.spkt.responseformat.BaseResponseFormat

data class ToDoResponseFormat (
    val toDoList: MutableList<ToDo>
) : BaseResponseFormat()