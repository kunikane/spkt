package com.sys5.spkt

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class MyApplication

fun main(args: Array<String>) {
    runApplication<MyApplication>(*args)
}
