package com.sys5.spkt.controller

import com.sys5.spkt.facade.ToDoFacade
import com.sys5.spkt.requestformat.todo.AddToDoRequestFormat
import com.sys5.spkt.requestformat.todo.GetToDoRequestFormat
import com.sys5.spkt.requestformat.todo.UpdateToDoTextRequestFormat
import com.sys5.spkt.responseformat.todo.AddToDoResponseFormat
import com.sys5.spkt.responseformat.todo.DeleteToDoResponseFormat
import com.sys5.spkt.responseformat.todo.ToDoResponseFormat
import com.sys5.spkt.responseformat.todo.UpdateToDoCompleteFlagResponseFormat
import com.sys5.spkt.responseformat.todo.UpdateToDoTextResponseFormat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/todo")
class ToDoController @Autowired constructor(private val todoFacade: ToDoFacade) {

    @GetMapping
    fun getToDoList(@ModelAttribute requestFormat: GetToDoRequestFormat): ToDoResponseFormat {
        return todoFacade.getToDo(requestFormat.userId)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addToDo(@RequestBody requestFormat: AddToDoRequestFormat): AddToDoResponseFormat {
        return todoFacade.addToDo(requestFormat.userId, requestFormat.text)
    }

    @RequestMapping(value = "{id:^[0-9]+$}", method = arrayOf(RequestMethod.PATCH))
    fun updateToDoText(@PathVariable id: Int, @RequestBody requestFormat: UpdateToDoTextRequestFormat): UpdateToDoTextResponseFormat {
        return todoFacade.updateToDoText(id, requestFormat.text)
    }

    @RequestMapping(value = "{id:^[0-9]+$}/complete", method = arrayOf(RequestMethod.PATCH))
    fun updateToDoCompleteFlag(@PathVariable id: Int): UpdateToDoCompleteFlagResponseFormat {
        return todoFacade.updateToDoCompleteFlag(id)
    }

    @RequestMapping(value = "{id:^[0-9]+$}", method = arrayOf(RequestMethod.DELETE))
    fun deleteToDo(@PathVariable id: Int): DeleteToDoResponseFormat {
        return todoFacade.deleteToDo(id)
    }
}