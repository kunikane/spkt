package com.sys5.spkt

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.boot.builder.SpringApplicationBuilder

@SpringBootApplication
open class MyApplication: SpringBootServletInitializer(){

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<MyApplication>(*args)
        }
    }

    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
        return application.sources(MyApplication::class.java!!)
    }

}

