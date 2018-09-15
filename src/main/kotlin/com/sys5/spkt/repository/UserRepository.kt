package com.sys5.spkt.repository

import com.sys5.spkt.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface UserRepository : JpaRepository<User, Long> {

    fun findOneById(id: Int): User

    @Transactional
    @Modifying
    @Query("UPDATE User AS t SET t.name = :name,t.email = :email WHERE t.id = :id")
    fun updateById(@Param("id") id: Int, @Param("name") name: String, @Param("email") email: String) : Int

    @Transactional
    @Modifying
    @Query("UPDATE User AS t SET t.password = :password WHERE t.id = :id")
    fun updatePasswordById(@Param("id") id: Int, @Param("password") password: String) : Int
}