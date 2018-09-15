package com.sys5.spkt.facade

import com.sys5.spkt.entity.User
import com.sys5.spkt.repository.UserRepository

import com.sys5.spkt.responseformat.user.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserFacade @Autowired constructor(private val userRepository: UserRepository) {

    fun getOne(id: Int): UserResponseFormat {
        var user: User = userRepository.findOneById(id)
        return UserResponseFormat(user)
    }

    fun getAll(): UsersResponseFormat {
        var users: MutableList<User> = userRepository.findAll()
        return UsersResponseFormat(users)
    }

    fun add(id: Int, name: String, email: String, password: String): AddUserResponseFormat {
        var t: User = User()
        t.id = id
        t.name = name
        t.email = email
        t.password = password
        var created: User = userRepository.save(t)
        return AddUserResponseFormat(created)
    }

    fun update(id: Int, name: String, email: String): UpdateUserResponseFormat {

        userRepository.updateById(id, name, email)

        var user: User = userRepository.findOneById(id)
        return UpdateUserResponseFormat(user)
    }


    fun updatePassword(id: Int, password: String): UpdateUserPasswordResponseFormat {

        userRepository.updatePasswordById(id, password)

        var user: User = userRepository.findOneById(id)
        return UpdateUserPasswordResponseFormat(user)
    }

    fun delete(id: Int): DeleteUserResponseFormat {
        var t: User = User()
        t.id = id
        userRepository.delete(t)
        return DeleteUserResponseFormat("OK")
    }
}