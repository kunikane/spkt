package com.sys5.spkt.controller

import com.sys5.spkt.facade.UserFacade
import com.sys5.spkt.requestformat.user.AddUserRequestFormat
import com.sys5.spkt.requestformat.user.GetAllUsersRequestFormat
import com.sys5.spkt.requestformat.user.UpdateUserPasswordRequestFormat
import com.sys5.spkt.requestformat.user.UpdateUserRequestFormat
import com.sys5.spkt.responseformat.user.*
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
@RequestMapping("/user")
class UserController @Autowired constructor(private val userFacade: UserFacade) {

    @GetMapping
    fun get(@ModelAttribute requestFormat: GetAllUsersRequestFormat): UsersResponseFormat {

        return userFacade.getAll()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun add(@RequestBody requestFormat: AddUserRequestFormat): AddUserResponseFormat {
        return userFacade.add(requestFormat.id, requestFormat.name, requestFormat.email, requestFormat.password)
    }

    @RequestMapping(value = "{id:^[0-9]+$}", method = arrayOf(RequestMethod.PATCH))
    fun update(@PathVariable id: Int, @RequestBody requestFormat: UpdateUserRequestFormat): UpdateUserResponseFormat {
        return userFacade.update(id, requestFormat.name, requestFormat.email)
    }

    @RequestMapping(value = "{id:^[0-9]+$}/password", method = arrayOf(RequestMethod.PATCH))
    fun updatePassword(@PathVariable id: Int, @RequestBody requestFormat: UpdateUserPasswordRequestFormat): UpdateUserPasswordResponseFormat {
        return userFacade.updatePassword(id, requestFormat.password)
    }

    @RequestMapping(value = "{id:^[0-9]+$}", method = arrayOf(RequestMethod.DELETE))
    fun delete(@PathVariable id: Int): DeleteUserResponseFormat {
        return userFacade.delete(id)
    }
}