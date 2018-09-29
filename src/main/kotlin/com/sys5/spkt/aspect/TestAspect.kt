package com.sys5.spkt.aspect

import org.aspectj.lang.annotation.*
import org.springframework.stereotype.Component
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around

@Aspect
@Component
class TestAspect {

    @Before("execution(public * com.sys5.spkt.controller.*.*(..))")
    fun before() {
        println("before !!")
    }

    @After("execution(public * com.sys5.spkt.controller.*.*(..))")
    fun after() {
        println("after !!")
    }

    @AfterReturning("execution(public * com.sys5.spkt.controller.*.*(..))")
    fun afterReturning() {
        println("afterReturning !!")
    }

    @AfterThrowing("execution(public * com.sys5.spkt.controller.*.*(..))")
    fun afterThrowing() {
        println("afterThrowing !!")
    }

    @Around("execution(public * com.sys5.spkt.controller.*.*(..))")
    @Throws(Throwable::class)
    fun around(pjp: ProceedingJoinPoint) {
        // 引数バインドしないとちゃんと動かない
        println("around - before !!")
        pjp.proceed()
        println("around - after !!")
    }

}